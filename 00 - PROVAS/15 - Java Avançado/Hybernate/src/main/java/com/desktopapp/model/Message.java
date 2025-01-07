package com.desktopapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbMessage")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    public Long getId() {
        return id_user;
    }
    public void setId(Long id) {
        this.id_user = id;
    }
    
    private Long id_from;
    private Long id_by;
    private String about;
    private String message;
    
    public Long getId_user() {
        return id_user;
    }
    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
    public Long getId_from() {
        return id_from;
    }
    public void setId_from(Long id_from) {
        this.id_from = id_from;
    }
    public Long getId_by() {
        return id_by;
    }
    public void setId_by(Long id_by) {
        this.id_by = id_by;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    

}
