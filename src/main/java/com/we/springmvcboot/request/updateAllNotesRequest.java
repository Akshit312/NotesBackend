package com.we.springmvcboot.request;

import java.util.List;

public class updateAllNotesRequest {
    private long userID;

    private List<updateRequest> userNote;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<updateRequest> getUserNote() {
        return userNote;
    }

    public void setUserNote(List<updateRequest> userNote) {
        this.userNote = userNote;
    }
}
