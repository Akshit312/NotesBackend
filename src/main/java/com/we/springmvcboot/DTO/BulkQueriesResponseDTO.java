package com.we.springmvcboot.DTO;

import java.util.List;

public class BulkQueriesResponseDTO {
    private String status = "200";
    private String message= "Request Successful";
    private ResponseListNoteAppNotesID data = new ResponseListNoteAppNotesID();

    public BulkQueriesResponseDTO(){}

    public BulkQueriesResponseDTO(List<ResponseNoteAppNotesID> userNote) {
        super();
        this.data.userNote = userNote;
    }

    public ResponseListNoteAppNotesID getData() {
        return data;
    }

    public void setData(ResponseListNoteAppNotesID data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
