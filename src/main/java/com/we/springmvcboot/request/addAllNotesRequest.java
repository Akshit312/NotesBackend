package com.we.springmvcboot.request;

import java.util.List;

public class addAllNotesRequest {
    private long userID;

    private List<addRequest> userNote;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<addRequest> getUserNote() {
        return userNote;
    }

    public void setUserNote(List<addRequest> userNote) {
        this.userNote = userNote;
    }
}
