package com.uk.sergiuivanov.springboot.notesapp.models;

/**
 * @author : Sergiu Ivanov
 * @project : NotesApp
 */
public class NoteNotFoundException extends Throwable{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
