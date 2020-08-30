package com.we.springmvcboot.Validator;

import com.we.springmvcboot.Repository.NotesRepository;
import com.we.springmvcboot.Repository.UserRepository;
import com.we.springmvcboot.exception.NotesException;
import com.we.springmvcboot.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotesValidator {

    @Autowired
    private static NotesRepository notesrepo;

    @Autowired
    private static UserRepository userrepo;

    public static void addNoteValidate(addNoteRequest input){
        if(input.getUserID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_USER_ID);
        if(input.getTitle()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_TITLE);
        if(input.getMessage()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_MESSAGE);
        if(input.getLabel()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_LABEL);
    }

    public static void updateNoteValidate(updateNoteRequest input){
        if(input.getUserID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_USER_ID);
        if(input.getTitle()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_TITLE);
        if(input.getMessage()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_MESSAGE);
        if(input.getNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_NOTES_ID);
    }

    public static void deleteNoteValidate(deleteNoteRequest input){
        if(input.getUserID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_USER_ID);
        if(input.getNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_NOTES_ID);
    }

    public static void addAllNotesValidator(addRequest input){
        if(input.getAppNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_AppNotesID);
        if(input.getTitle()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_TITLE);
        if(input.getMessage()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_MESSAGE);
        if(input.getDate()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_DATE);
        if(input.getLabel()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_LABEL);
    }

    public static void updateAllNotesValidator(updateRequest input){
        if(input.getAppNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_AppNotesID);
        if(input.getTitle()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_TITLE);
        if(input.getMessage()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_MESSAGE);
        if(input.getDate()==null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_DATE);
        if(input.getLabel()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_LABEL);
        if(input.getNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_NOTES_ID);

    }

    public static void deleteAllNotesValidator(deleteRequest input){
        if(input.getAppNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_AppNotesID);
        if(input.getNotesID()==0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_NOTES_ID);
    }


}
