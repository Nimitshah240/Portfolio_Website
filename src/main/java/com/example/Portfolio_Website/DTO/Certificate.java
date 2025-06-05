package com.example.Portfolio_Website.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description -  Entity class used to get certificate details for the portfolio website.
//                Get certificate name, id, file content as byte array, and year of issuance.
//                Designed to be persisted in a database using JPA.
// Updated on - -
// Updated Version - -
// Input - none

@Entity
public class Certificate {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Lob
    @Column
    private byte[] file;

    @Column
    private int year;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getFile() {
        return file;
    }

    public int getYear() {
        return year;
    }
}

