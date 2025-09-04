package com.quicknotes.quicknotes.repository;

import com.quicknotes.quicknotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
