package com.pankajsoftware.book_networkooo.dto;

import lombok.Data;

@Data
public class NoteDto {

    private Long id;

     private Long userId; // kept harcoded sn=

    private String text;
    private boolean isSyncedWithCloud;




}
