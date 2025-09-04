package com.quicknotes.quicknotes.service;


import com.quicknotes.quicknotes.entity.Note;
import com.quicknotes.quicknotes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public Note saveOrUpdate(Note note)
    {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes()
    {
        return  noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id)
    {
        return noteRepository.findById(id);
    }

    public void deleteNoteById(Long id)
    {
        noteRepository.deleteById(id);
    }



}
