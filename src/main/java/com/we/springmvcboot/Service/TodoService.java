package com.we.springmvcboot.Service;


import com.we.springmvcboot.DTO.BulkQueriesResponseDTO;
import com.we.springmvcboot.DTO.ResponseNoteAppNotesID;
import com.we.springmvcboot.DTO.SingleQueryDTO;
import com.we.springmvcboot.Entity.Notes;
import com.we.springmvcboot.Entity.User;
import com.we.springmvcboot.Repository.NotesRepository;
import com.we.springmvcboot.Repository.UserRepository;
import com.we.springmvcboot.Validator.NotesValidator;
import com.we.springmvcboot.Validator.UserValidator;
import com.we.springmvcboot.convertor.convertListNotesToDTO;
import com.we.springmvcboot.exception.NotesException;
import com.we.springmvcboot.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private UserRepository userrepo;

    @Autowired
    private NotesRepository notesrepo;


    public SingleQueryDTO createPerson(String email) {
        UserValidator.EmailIDValidate(email);

        if (userrepo.findByEmailID(email).isEmpty()) {
            User u = new User(email);
            userrepo.save(u);
            ArrayList<Notes> empty = new ArrayList<Notes>();
            return convertListNotesToDTO.convertIdListNotesToDTO(empty, userrepo.findByEmailID(email).get(0).getId());
        } else {
            long id = userrepo.findByEmailID(email).get(0).getId();
            ArrayList<Notes> NotesList = new ArrayList<Notes>();
            NotesList.addAll(userrepo.findByEmailID(email).get(0).getUsernotes());
            return convertListNotesToDTO.convertIdListNotesToDTO(NotesList, id);
        }
    }

    public SingleQueryDTO addNote(addNoteRequest input) {

        NotesValidator.addNoteValidate(input);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(new Date());
        ArrayList<Notes> note = new ArrayList();

        User u = userrepo.findById(input.getUserID()).orElse(null);
        if (u == null)
            throw new NotesException(NotesException.NotesExceptionEnum.USER_NOT_FOUND);

        long notesID = notesrepo.save(new Notes(input.getTitle(), input.getMessage(), date, u, input.getLabel())).getId();

        note.add(new Notes(notesID, input.getTitle(), input.getMessage(), date, input.getLabel()));

        return convertListNotesToDTO.convertIdListNotesToDTO(note, input.getUserID());

    }


    public SingleQueryDTO updateNote(updateNoteRequest input) {
        NotesValidator.updateNoteValidate(input);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(new Date());

        Notes n = notesrepo.findByIdAndDeletedFalse(input.getNotesID());

        if (n == null)
            throw new NotesException(NotesException.NotesExceptionEnum.NOTE_NOT_FOUND);

        n.setDate(date);
        n.setMessage(input.getMessage());
        n.setTitle(input.getTitle());
        n.setLabel(1);
        notesrepo.save(n);

        return convertListNotesToDTO.convertIdListNotesToDTO(Collections.singletonList(n), input.getUserID());
    }

    public SingleQueryDTO deleteNote(deleteNoteRequest input) {
        NotesValidator.deleteNoteValidate(input);
        Notes notes = notesrepo.findByIdAndDeletedFalse(input.getNotesID());
        if (notes == null)
            throw new NotesException(NotesException.NotesExceptionEnum.NOTE_NOT_FOUND);
        notesrepo.delete(notes);

        return convertListNotesToDTO.convertIdListNotesToDTO(null, input.getUserID());

    }


    public BulkQueriesResponseDTO addAllNotes(addAllNotesRequest input) {

        UserValidator.UserIDValidate(input.getUserID());
        List<addRequest> notes = input.getUserNote();

        User user = userrepo.findById(input.getUserID()).orElse(null);
        if (user == null)
            throw new NotesException(NotesException.NotesExceptionEnum.USER_NOT_FOUND);

        ArrayList<ResponseNoteAppNotesID> userNote = new ArrayList();

        for (addRequest u : notes) {
            NotesValidator.addAllNotesValidator(u);
            long appNotesID = u.getAppNotesID();
            long notesID = notesrepo.save(new Notes(u.getTitle(), u.getMessage(), u.getDate(), user, u.getLabel())).getId();
            userNote.add(new ResponseNoteAppNotesID(notesID, appNotesID));
        }
        return convertListNotesToDTO.convertUserNoteToBulkDTO(userNote);

    }


    public BulkQueriesResponseDTO deleteAllNotes(deleteAllNotesRequest input) {

        List<deleteRequest> notes = input.getUserNote();

        User user = userrepo.findById(input.getUserID()).orElse(null);
        if (user == null)
            throw new NotesException(NotesException.NotesExceptionEnum.USER_NOT_FOUND);

        ArrayList<ResponseNoteAppNotesID> userNote = new ArrayList();

        for (deleteRequest u : notes) {
            NotesValidator.deleteAllNotesValidator(u);
            long appNotesID = u.getAppNotesID();
            long notesID = u.getNotesID();

            if (notesrepo.findByIdAndDeletedFalse(notesID) != null) {
                notesrepo.deleteById(notesID);
                userNote.add(new ResponseNoteAppNotesID(notesID, appNotesID));
            }
        }
        return convertListNotesToDTO.convertUserNoteToBulkDTO(userNote);

    }

    public BulkQueriesResponseDTO updateAllNotes(updateAllNotesRequest input) {
        UserValidator.UserIDValidate(input.getUserID());
        ArrayList<ResponseNoteAppNotesID> userNote = new ArrayList();
        List<updateRequest> notes = input.getUserNote();

        for (updateRequest u : notes) {

            long notesID = u.getNotesID();
            Notes n = notesrepo.findByIdAndDeletedFalse(notesID);
            if (n == null)
                continue;

            n.setLabel(u.getLabel());
            n.setTitle(u.getTitle());
            n.setMessage(u.getMessage());
            n.setDate(u.getDate());
            notesrepo.save(n);
            userNote.add(new ResponseNoteAppNotesID(notesID, u.getAppNotesID()));
        }

        return convertListNotesToDTO.convertUserNoteToBulkDTO(userNote);
    }

}

