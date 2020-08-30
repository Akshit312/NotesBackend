package com.we.springmvcboot.request;

public class deleteRequest {
    private long appNotesID;

    private long notesID;

    public long getAppNotesID() {
        return appNotesID;
    }

    public void setAppNotesID(long appNotesID) {
        this.appNotesID = appNotesID;
    }

    public long getNotesID() {
        return notesID;
    }

    public void setNotesID(long notesID) {
        this.notesID = notesID;
    }
}
