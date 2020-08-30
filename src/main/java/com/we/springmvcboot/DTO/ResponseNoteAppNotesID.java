package com.we.springmvcboot.DTO;

public class ResponseNoteAppNotesID {
    private long notesID;
    private long appNotesID;

    private ResponseNoteAppNotesID(){};

    public ResponseNoteAppNotesID(long notesID, long appNotesID) {
        super();
        this.notesID = notesID;
        this.appNotesID = appNotesID;
    }

    public long getNotesID() {
        return notesID;
    }

    public void setNotesID(long notesID) {
        this.notesID = notesID;
    }

    public long getAppNotesID() {
        return appNotesID;
    }

    public void setAppNotesID(long appNotesID) {
        this.appNotesID = appNotesID;
    }
}
