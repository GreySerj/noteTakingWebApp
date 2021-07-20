package com.uk.sergiuivanov.springboot.notesapp.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Sergiu Ivanov
 * @project : NotesApp
 */
@Service
public class NoteService {

    @Autowired private NotesRepository repo;

    public List<Note> listAll(){
        return (List<Note>) repo.findAll();
    }

    public void save(Note note){
        repo.save(note);
    }

    public void delete(Integer id) throws NoteNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new NoteNotFoundException("Could not find any notes with specified ID");
        }
        repo.deleteById(id);
    }


    public Note get(Integer id) throws NoteNotFoundException{
        Optional<Note> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NoteNotFoundException("Could not find any note with specified ID");

    }
}
