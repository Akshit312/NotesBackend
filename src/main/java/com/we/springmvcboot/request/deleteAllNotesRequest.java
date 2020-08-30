package com.we.springmvcboot.request;

import java.util.List;

public class deleteAllNotesRequest {

    private long userID;

    private List<deleteRequest> userNote;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<deleteRequest> getUserNote() {
        return userNote;
    }

    public void setUserNote(List<deleteRequest> userNote) {
        this.userNote = userNote;
    }
}
