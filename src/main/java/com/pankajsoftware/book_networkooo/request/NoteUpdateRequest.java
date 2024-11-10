package com.pankajsoftware.book_networkooo.request;

import lombok.Data;

@Data
public class NoteUpdateRequest {
   private Long id; // id not needed to add to database sn= {isn= made extra code

    private Long userId; // kept harcoded sn=

    private String text;
    private boolean IsSyncedWithCloud;
}
