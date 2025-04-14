package com.example.Portfolio_Website;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description -  Entity class used to get personal details for the portfolio website.
//                Get name, email, phone, location, LinkedIn, whatsapp, instagram, GitHub, development type and description/aboutme details.
//                Designed to be persisted in a database using JPA.
// Updated on - -
// Updated Version - -
// Input - none

@Component
@ConfigurationProperties(prefix = "personaldetail")
public class PersonalDetail {
    private String name;
    private String email;
    private String phone;
    private String location;
    private String linkedin;
    private String instagram;
    private String whatsapp;
    private String developer;
    private String github;
    private String aboutme;


    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }
}