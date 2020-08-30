package com.we.springmvcboot.Controller;

import com.we.springmvcboot.DTO.BulkQueriesResponseDTO;
import com.we.springmvcboot.DTO.SingleQueryDTO;
import com.we.springmvcboot.Service.TodoService;
import com.we.springmvcboot.request.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoservice;
    @ApiOperation(value = "API for login User", notes = "This API accepts email ID as input and return all the notes corresponding to that email. Also, in case email ID does not already exists in the database, it will generate and return new userID and empty list in user notes field.")
    @GetMapping(value = "/loginUser" )
    public SingleQueryDTO createPerson(@RequestParam(value="emailid", required=false) String email)  {
      return todoservice.createPerson(email);
    }

    @ApiOperation(value = "API for adding single note", notes = "This API is for adding a note and in response, it will return the note and it's notes ID")
    @PostMapping(value = "/addNote")
    public SingleQueryDTO addNote(@RequestBody addNoteRequest input)  {
        return todoservice.addNote(input);
    }

    @ApiOperation(value = "API for updating existing note", notes = "This API is for updating already existing note using the notesID. If a invalid notes ID is received, it will send 'UserID is missing' message")
    @PutMapping(value = "/updateNote")
    public SingleQueryDTO alterNote(@RequestBody updateNoteRequest input) {
        return todoservice.updateNote(input);
    }

    @ApiOperation(value= "API for deleting note", notes = "This API is for deleting an existing note. If an invalid notesID is received, it will send 'Invalid Notes ID' message")
    @DeleteMapping(value = "/deleteNote")
    public SingleQueryDTO deleteNote(@RequestBody deleteNoteRequest input) {
        return todoservice.deleteNote(input);
    }

    @ApiOperation(value="API for adding a list of notes", notes ="This API is for adding list of notes for an existing user. In response, it will return the NotesID of all the newly added notes")
    @PostMapping(value = "/addAllNotes")
    public BulkQueriesResponseDTO addAllNotes(@RequestBody addAllNotesRequest input) {
        return todoservice.addAllNotes(input);
    }

    @ApiOperation(value="API for deleting a list of notes", notes ="This API is for deleting an existing note. In response, it will return the NotesID of all those notes which were successfully deleted")
    @DeleteMapping(value = "/deleteAllNotes")
    public BulkQueriesResponseDTO deleteAllNotes(@RequestBody deleteAllNotesRequest input) {
        return todoservice.deleteAllNotes(input);
    }
    @ApiOperation(value = "API for updating a list of notes", notes = "This API is for updating an existing note. In response, it will return the NotesID of all those notes which were successfully updated")
    @PutMapping(value = "/updateAllNotes")
    public BulkQueriesResponseDTO updateAllNotes(@RequestBody updateAllNotesRequest input) {
        return todoservice.updateAllNotes(input);
    }

}
