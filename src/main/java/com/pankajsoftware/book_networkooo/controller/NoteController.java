package com.pankajsoftware.book_networkooo.controller;


import com.pankajsoftware.book_networkooo.dto.NoteDto;
import com.pankajsoftware.book_networkooo.exceptions.ResourceNotFoundException;

//import com.pankajsoftware.book_networkooo.request.AddProductRequest;
//import com.pankajsoftware.book_networkooo.dto.ProductDto;
//import com.pankajsoftware.book_networkooo.exceptions.ResourceNotFoundException;

import com.pankajsoftware.book_networkooo.model.Note;
import com.pankajsoftware.book_networkooo.request.AddNoteRequest;
//import com.pankajsoftware.book_networkooo.request.*;
import com.pankajsoftware.book_networkooo.request.NoteUpdateRequest;
import com.pankajsoftware.book_networkooo.response.ApiResponse;
//import com.pankajsoftware.book_networkooo.service.product.IProductService;
import com.pankajsoftware.book_networkooo.service.note.INoteService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("notes")
public class NoteController {

    private static NoteDto myNoteDto = new NoteDto();

    private final INoteService noteService;

    @GetMapping("/all")
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        List<NoteDto> convertedNotes = noteService.getConvertedNotes(notes);

        return  ResponseEntity.ok(convertedNotes);
//        return  ResponseEntity.ok(new ApiResponse("success", convertedNotes));

    }

    @GetMapping("note/{noteId}/note")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long noteId) {
        try {
            Note note = noteService.getNoteById(noteId);
            NoteDto noteDto = noteService.convertToDto(note);
            // return  ResponseEntity.ok(new ApiResponse("success", noteDto));
            return  ResponseEntity.ok(noteDto);

        } catch (ResourceNotFoundException e) {
            // return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
            return ResponseEntity.status(NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<NoteDto> addNote(@RequestBody AddNoteRequest note) {
        try {
            Note theNote = noteService.addNote(note);
            NoteDto noteDto = noteService.convertToDto(theNote);
            // return ResponseEntity.ok(new ApiResponse("Add note success!", noteDto));
            return ResponseEntity.ok(noteDto);
        } catch (Exception e) {
            // return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(myNoteDto);
        }
    }


    @PutMapping("/note/{noteId}/update")
    public  ResponseEntity<NoteDto> updateNote(@RequestBody NoteUpdateRequest request, @PathVariable Long noteId) {
        try {
            Note theNote = noteService.updateNote(request, noteId);
            NoteDto noteDto = noteService.convertToDto(theNote);
            // return ResponseEntity.ok(new ApiResponse("Update note success!", noteDto));
            return ResponseEntity.ok(noteDto);
        } catch (ResourceNotFoundException e) {
            // return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
            return ResponseEntity.status(NOT_FOUND).body( myNoteDto);
        }
    }


    @DeleteMapping("/note/{noteId}/delete")
    public ResponseEntity<Long> deleteNote(@PathVariable Long noteId) {
        try {
            noteService.deleteNoteById(noteId);
            // return ResponseEntity.ok(new ApiResponse("Delete note success!", noteId));
            return ResponseEntity.ok(noteId);
        } catch (ResourceNotFoundException e) {
            // return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
            return ResponseEntity.status(NOT_FOUND).body(noteId);
        }
    }


}
