package com.we.springmvcboot.exception;

import org.springframework.http.HttpStatus;

public class NotesException extends RuntimeException {

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NotesException(NotesExceptionEnum testExceptionEnum){
        super(testExceptionEnum.description);
        this.httpStatus = testExceptionEnum.httpStatus;
    }


    public enum NotesExceptionEnum {
        NOTE_NOT_FOUND(HttpStatus.BAD_REQUEST,"Invalid Notes ID"),
        USER_NOT_FOUND(HttpStatus.BAD_REQUEST,"User not found"),
        MISSING_LABEL(HttpStatus.BAD_REQUEST,"Label is missing"),
        MISSING_NOTES_ID(HttpStatus.BAD_REQUEST,"NotesID is missing"),
        MISSING_TITLE(HttpStatus.BAD_REQUEST,"Title is missing"),
        MISSING_MESSAGE(HttpStatus.BAD_REQUEST,"Message is missing"),
        MISSING_DATE(HttpStatus.BAD_REQUEST,"Date is missing"),
        MISSING_AppNotesID(HttpStatus.BAD_REQUEST,"AppNotesId is missing"),
        MISSING_EMAIL(HttpStatus.BAD_REQUEST,"EmailID is missing"),
        MISSING_USER_ID(HttpStatus.BAD_REQUEST,"UserID is missing"),
        INVALID_DATE(HttpStatus.BAD_REQUEST,"Invalid Date Format");


        private final HttpStatus httpStatus;
        private final String     description;


        NotesExceptionEnum( HttpStatus httpStatus, String description){
            this.httpStatus = httpStatus;
            this.description = description;
        }
    }


}