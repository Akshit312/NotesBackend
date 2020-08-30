package com.we.springmvcboot.request;

public class deleteNoteRequest {
    private long userID;

    private long notesID;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getNotesID() {
        return notesID;
    }

    public void setNotesID(long notesID) {
        this.notesID = notesID;
    }
}
