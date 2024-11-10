package com.pankajsoftware.book_networkooo.repository;

import com.pankajsoftware.book_networkooo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
