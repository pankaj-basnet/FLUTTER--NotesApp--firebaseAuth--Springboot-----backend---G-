package com.pankajsoftware.book_networkooo.request;

import lombok.Data;

@Data
public class AddNoteRequest {
   private Long id; // id not needed to add to database sn= {isn= made extra code

    private Long userId; // kept harcoded sn=

    private String text;
    private boolean isSyncedWithCloud;
}
