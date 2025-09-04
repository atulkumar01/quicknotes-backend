package com.quicknotes.quicknotes.controller;

import com.quicknotes.quicknotes.entity.Note;
import com.quicknotes.quicknotes.kafka.KafkaProducerService;
import com.quicknotes.quicknotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.*;


@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {

        Note savedNote = noteService.saveOrUpdate(note);

        String message = "NOTE_CREATED:id=" + savedNote.getId() + ",title=" + savedNote.getTitle();
        kafkaProducerService.publishNoteCreated(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes()
    {
        List<Note>  listNote = noteService.getAllNotes();
        return ResponseEntity.status(HttpStatus.OK).body(listNote);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id)
    {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

      }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id)
    {
        noteService.deleteNoteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Note Deleted Successfully");
    }








}
