package com.we.springmvcboot.request;

public class updateNoteRequest {

    private long userID;

    private String title;

    private String message;

    private long notesID;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
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

    public long getNotesID() {
        return notesID;
    }

    public void setNotesID(long notesID) {
        this.notesID = notesID;
    }
}
