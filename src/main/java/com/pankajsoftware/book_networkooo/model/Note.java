package com.pankajsoftware.book_networkooo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     private Long userId; // kept harcoded sn=

    private String text;
    private boolean isSyncedWithCloud;


    // const idColumn = 'id';
    // const emailColumn = 'email';
    // const userIdColumn = 'user_id';
    // const textColumn = 'text';
    // const isSyncedWithCloudColumn = 'is_synced_with_cloud';

    public Note(Long id, Long userId, String text, boolean isSyncedWithCloud){
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.isSyncedWithCloud = isSyncedWithCloud;
    }
}
