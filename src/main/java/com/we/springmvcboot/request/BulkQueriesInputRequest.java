package com.we.springmvcboot.request;

import java.util.List;

public class BulkQueriesInputRequest {
    private long userID;
    private List<UserNoteResponseRequest> userNote;

    public BulkQueriesInputRequest() {
    }

    public BulkQueriesInputRequest(long userID, List<UserNoteResponseRequest> userNote) {
        this.userID = userID;
        this.userNote = userNote;
    }

    public BulkQueriesInputRequest(List<UserNoteResponseRequest> userNote) {

        this.userNote = userNote;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<UserNoteResponseRequest> getuserNote() {
        return userNote;
    }

}
