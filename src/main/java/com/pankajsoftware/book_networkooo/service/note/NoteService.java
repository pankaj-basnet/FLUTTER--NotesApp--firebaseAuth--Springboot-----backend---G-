package com.pankajsoftware.book_networkooo.service.note;

import com.pankajsoftware.book_networkooo.dto.NoteDto;
import com.pankajsoftware.book_networkooo.exceptions.NoteNotFoundException;
import com.pankajsoftware.book_networkooo.exceptions.ResourceNotFoundException;
import com.pankajsoftware.book_networkooo.model.Note;
import com.pankajsoftware.book_networkooo.repository.NoteRepository;
import com.pankajsoftware.book_networkooo.request.AddNoteRequest;
import com.pankajsoftware.book_networkooo.request.NoteUpdateRequest;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.Locale.Category;

import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService implements INoteService {

    private final NoteRepository noteRepository;
    private final ModelMapper modelMapper;


    @Override
    public Note getNoteById(Long id){
        return noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note not found "));}

        @Override
        public List<Note> getAllNotes(){
                return noteRepository.findAll();
        }

    public Note addNote(AddNoteRequest request){
            return noteRepository.save(createNote(request));

    }

    private Note createNote(AddNoteRequest request){
        return  new Note(
                request.getId(),
                request.getUserId(),
                request.getText(),
                request.isSyncedWithCloud()
        );
    }

    @Override
    public List<NoteDto> getConvertedNotes(List<Note> notes) {
        return notes.stream().map(this::convertToDto).toList();
    }

    @Override
    public NoteDto convertToDto(Note note) {
        NoteDto noteDto = modelMapper.map(note, NoteDto.class);
        
        return noteDto;
    }


    @Override
    public void deleteNoteById(Long id) {
        noteRepository.findById(id)
                .ifPresentOrElse(noteRepository::delete,
                        () -> {throw new ResourceNotFoundException("Note not found!");});
    }


    @Override
    public Note updateNote(NoteUpdateRequest request, Long noteId) {
        return noteRepository.findById(noteId)
                .map(existingNote -> updateExistingNote(existingNote,request))
                .map(noteRepository :: save)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found!"));
    }

    
    private Note updateExistingNote(Note existingNote, NoteUpdateRequest request) {
        existingNote.setUserId(request.getUserId());
        existingNote.setText(request.getText());
        // existingNote.setIsSyncedWithCloud(request.getIsSyncedWithCloud()); // IsSyncedWithCloud not working sn=
        
        return  existingNote;

    }
}
