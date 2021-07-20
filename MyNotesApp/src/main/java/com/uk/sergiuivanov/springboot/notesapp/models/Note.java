package com.uk.sergiuivanov.springboot.notesapp.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Sergiu Ivanov
 * @project : NotesApp
 */
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "published_on")
    private String publishedOn;

    @Column(nullable = false, length = 45)
    private String type;

    @Column(length = 5000)
    private String content;

    public Note() {
        setCreatedOn();
        setPublishedOn();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        this.createdOn = DATE_FORMAT.format(date);
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn() {
        Date date = new Date();
        SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
        this.publishedOn = TIME_FORMAT.format(date);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", createdOn='" + createdOn + '\'' +
                ", publishedOn='" + publishedOn + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
