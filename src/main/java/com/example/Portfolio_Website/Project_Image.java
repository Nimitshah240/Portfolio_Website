package com.example.Portfolio_Website;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description -  Entity class used to get project images for the portfolio website.
//                Get project image id, pId(Foreign key for Project), image in byte format.
//                Designed to be persisted in a database using JPA.
// Updated on - -
// Updated Version - -
// Input - none

@Entity
public class Project_Image {

    @Id
    @Column
    private Long id;

    @Column(name = "p_id") // map to DB column
    private Long pId;

    @Lob
    @Column
    private byte[] image;

    public Long getId() {
        return id;
    }

    public Long getPId() {
        return pId;
    }

    public byte[] getImage() {
        return image;
    }
}
