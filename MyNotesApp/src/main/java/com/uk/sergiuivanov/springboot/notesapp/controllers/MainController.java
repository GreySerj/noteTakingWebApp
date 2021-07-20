package com.uk.sergiuivanov.springboot.notesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Sergiu Ivanov
 * @project : NotesApp
 */
@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage(){
        return "index";
    }
}
