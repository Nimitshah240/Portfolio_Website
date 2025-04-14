package com.example.Portfolio_Website;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description -  Entity class used to store contact details for the portfolio website.
//                Stores contact id, name, email,subject and message.
//                Designed to be persisted in a database using JPA.
// Updated on - -
// Updated Version - -
// Input - none
@Entity
public class Contact {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String subject;

    @Column
    private String message;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Contact setMessage(String message) {
        this.message = message;
        return this;
    }

    public Contact setId(String id) {
        this.id = id;
        return this;
    }
}
