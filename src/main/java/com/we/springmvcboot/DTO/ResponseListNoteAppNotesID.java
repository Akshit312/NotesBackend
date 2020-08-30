package com.we.springmvcboot.DTO;

import java.util.List;

public class ResponseListNoteAppNotesID {
    List<ResponseNoteAppNotesID> userNote;

    public ResponseListNoteAppNotesID(){};
    public ResponseListNoteAppNotesID(List<ResponseNoteAppNotesID> userNote) {
        super();
        this.userNote = userNote;
    }

    public List<ResponseNoteAppNotesID> getUserNote() {
        return userNote;
    }

    public void setUserNote(List<ResponseNoteAppNotesID> userNote) {
        this.userNote = userNote;
    }
}
