package com.we.springmvcboot.DTO;

import com.we.springmvcboot.Entity.Notes;

import java.util.ArrayList;
import java.util.List;

public class SingleQueryDTO {
    private String status = "200";
    private String message= "Request Successful";
    private SingleQueryResponseDTO data=new SingleQueryResponseDTO();

    public SingleQueryDTO(long id, List<Notes> notes){
        this.data.setUserID(id);
        this.data.setUserNotes(notes);

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

    public SingleQueryResponseDTO getData() {
        return data;
    }

    public void setData(SingleQueryResponseDTO data) {
        this.data = data;
    }
}
