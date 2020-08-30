package com.we.springmvcboot.DTO;

public class NotesDTO {
private Long notesID;
private String title;
private String message;
private String Date;

    public Long getNotesID() {
        return notesID;
    }

    public void setNotesID(Long notesID) {
        this.notesID = notesID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

