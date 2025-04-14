package com.example.Portfolio_Website;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description -  Entity class used to get project for the portfolio website.
//                Get project id, name, logo in byte format, description, tools and links.
//                Designed to be persisted in a database using JPA.
// Updated on - -
// Updated Version - -
// Input - none

@Entity
public class Project {
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Lob
    @Column
    private byte[] logo;

    @Column
    private String description;

    @Column
    private String tools;

    @Column
    private String link;

    public String getLink() {
        return link;
    }

    public String getTools() {
        return tools;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}


