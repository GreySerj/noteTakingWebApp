package com.uk.sergiuivanov.springboot.notesapp.models;

import org.springframework.data.repository.CrudRepository;

/**
 * @author : Sergiu Ivanov
 * @project : NotesApp
 */
public interface NotesRepository extends CrudRepository<Note, Integer> {
    long countById(Integer id);
}
