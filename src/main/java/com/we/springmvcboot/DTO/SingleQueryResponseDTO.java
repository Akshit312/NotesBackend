package com.we.springmvcboot.DTO;

import com.we.springmvcboot.Entity.Notes;

import java.util.List;

public class SingleQueryResponseDTO {


    private List<Notes> UserNotes;

    private long userID;

    public SingleQueryResponseDTO() {
    }

    public SingleQueryResponseDTO(List<Notes> UserNotes, long userID) {
        super();
        this.userID = userID;
        this.UserNotes = UserNotes;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<Notes> getUserNotes() {
        return UserNotes;
    }

    public void setUserNotes(List<Notes> userNotes) {
        UserNotes = userNotes;
    }

    @Override
    public String toString() {
        return "SingleQueryResponseDTO [userID=" + userID + ", UserNotes=" + UserNotes + "]";
    }


}
