package com.uk.sergiuivanov.springboot.notesapp.controllers;

import com.uk.sergiuivanov.springboot.notesapp.models.Note;
import com.uk.sergiuivanov.springboot.notesapp.models.NoteNotFoundException;
import com.uk.sergiuivanov.springboot.notesapp.models.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author : Sergiu Ivanov

 * @project : NotesApp
 */
@Controller
public class NoteCotroller {

    @Autowired private NoteService noteService;

    @GetMapping("/notes")
    public String showNoteList(Model model){
        List<Note> listNotes = noteService.listAll();

        model.addAttribute("listNotes", listNotes);
        return "notes";
    }

    @GetMapping("/notes/new")
    public String showNewForm(Model model){
        model.addAttribute("note", new Note());
        return "note_form";
    }

    @PostMapping("/notes/save")
    public String saveNote(Note note, RedirectAttributes ra){

        noteService.save(note);
        ra.addFlashAttribute("message", "The note was created successfully");
        return "redirect:/notes";
    }

    @GetMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            noteService.delete(id);
            ra.addFlashAttribute("message", "The note ID: " + id + " was deleted successfully");
        } catch (NoteNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage() );
        }
        return "redirect:/notes";
    }

    @GetMapping("/notes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Note note = noteService.get(id);
            model.addAttribute("note", note);
            model.addAttribute("pageTitle", "Edit note (ID: " + id + ")");
//            ra.addFlashAttribute("message", "The note ID: " + id + " was edited successfully");
            return "note_form";
        } catch (NoteNotFoundException e) {
            ra.addFlashAttribute("message", "The user has been saved successfully" );
        }
        return "redirect:/notes";
    }
}
