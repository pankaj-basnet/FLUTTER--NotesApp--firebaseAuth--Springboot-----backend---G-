package com.pankajsoftware.book_networkooo.service.note;

import com.pankajsoftware.book_networkooo.dto.NoteDto;
import com.pankajsoftware.book_networkooo.model.Note;
import com.pankajsoftware.book_networkooo.request.AddNoteRequest;
import com.pankajsoftware.book_networkooo.request.NoteUpdateRequest;

import java.util.List;

public interface INoteService {

    Note getNoteById(Long id);

    List<Note> getAllNotes();

     List<NoteDto> getConvertedNotes(List<Note> notes);

     NoteDto convertToDto(Note note);


     Note addNote(AddNoteRequest note);

     Note updateNote(NoteUpdateRequest note, Long noteId);

     void deleteNoteById(Long id);





}
