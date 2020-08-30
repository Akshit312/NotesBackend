package com.we.springmvcboot.convertor;

import com.we.springmvcboot.DTO.BulkQueriesResponseDTO;
import com.we.springmvcboot.DTO.ResponseNoteAppNotesID;
import com.we.springmvcboot.DTO.SingleQueryDTO;
import com.we.springmvcboot.Entity.Notes;

import java.util.ArrayList;
import java.util.List;

public class convertListNotesToDTO {

    public convertListNotesToDTO() {
    }

    public static SingleQueryDTO convertIdListNotesToDTO(List<Notes> notes, long id){
        return new SingleQueryDTO(id, notes);
    }

    public static BulkQueriesResponseDTO convertUserNoteToBulkDTO(ArrayList<ResponseNoteAppNotesID> usernote){
        return new BulkQueriesResponseDTO(usernote);
    }


}
