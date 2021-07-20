package com.uk.sergiuivanov.springboot.notesapp;

import com.uk.sergiuivanov.springboot.notesapp.models.Note;
import com.uk.sergiuivanov.springboot.notesapp.models.NotesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/**
 * @author : Sergiu Ivanov
 * @project : NotesApp
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class NotesRepositoryTest {

    @Autowired private NotesRepository repo;
    @Test
    public void testAddNew(){
        Note note = new Note();
        note.setCreatedOn();
        note.setPublishedOn();
        note.setType("Work");
        note.setContent("scrum meeting");

        Note savedNote = repo.save(note);
        Assertions.assertThat(savedNote).isNotNull();
        Assertions.assertThat(savedNote.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<Note> notes = repo.findAll();
        Assertions.assertThat(notes).hasSizeGreaterThan(0);
        for (Note note: notes){
            System.out.println(note);
        }
    }

    @Test
    public void testUpdate(){
        Integer noteId = 1;
        Optional<Note> optionalNote = repo.findById(noteId);
        Note note = optionalNote.get();
        note.setType("work");
        repo.save(note);
        Note updatedNote = repo.findById(noteId).get();
        Assertions.assertThat(updatedNote.getType()).isEqualTo("work");
    }

    @Test
    public void testGet(){
        Integer noteId = 2;
        Optional<Note> optionalNote = repo.findById(noteId);
        Assertions.assertThat(optionalNote).isPresent();
        System.out.println(optionalNote.get());
    }

    @Test
    public void testDelete(){
        Integer integer = 1;
        repo.deleteById(integer);
        Optional<Note> optionalNote = repo.findById(integer);
        Assertions.assertThat(optionalNote).isNotPresent();

    }
}
