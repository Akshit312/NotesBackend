package com.we.springmvcboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionResolver extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NotesException.class })
    protected ResponseEntity<? extends ErrorDetails> handleException(NotesException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), String.valueOf(e.getHttpStatus().value()),e.getMessage(), null),e.getHttpStatus());
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<? extends ErrorDetails> handleUnknownException(Exception ex, WebRequest request) {
        ErrorDetails er = new ErrorDetails(new Date(), "500", ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
