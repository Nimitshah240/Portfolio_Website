package com.example.Portfolio_Website.DTO;

import jakarta.persistence.*;

import java.io.Serializable;

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description -  Entity class used to get skills for the portfolio website.
//                Get skills id, name, image in byte format and type.
//                Designed to be persisted in a database using JPA.
// Updated on - -
// Updated Version - -
// Input - none

@Entity
public class Skills implements Serializable {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Lob
    @Column
    private byte[] image;

    @Column
    private String type;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

}

