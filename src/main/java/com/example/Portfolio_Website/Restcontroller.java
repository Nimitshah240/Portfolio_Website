package com.example.Portfolio_Website;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - RestController file to handle all the HTTP Request to get different information.
// Updated on - -
// Updated Version - -
// Input - none
//@CrossOrigin(origins = "http://localhost")
@RestController
public class Restcontroller {

    private PersonalDetail personaldetail;
    private final SkillRepository skillrepository;
    private final CertificateRepository certificaterepository;
    private final ProjectRepository projectrepository;
    private final Project_ImageRepository projectimagerepository;
    private final ContactRepository contactrepository;

    @Autowired
    public Restcontroller(PersonalDetail personaldetail, SkillRepository skillrepository, CertificateRepository certificaterepository1, ProjectRepository projectrepository, Project_ImageRepository projectimagerepository, ContactRepository contactrepository) {
        this.personaldetail = personaldetail;
        this.skillrepository = skillrepository;
        this.certificaterepository = certificaterepository1;
        this.projectrepository = projectrepository;
        this.projectimagerepository = projectimagerepository;
        this.contactrepository = contactrepository;
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/").
    //               Loads and returns the content of the static index.html file from classpath.
    //               Used to serve the main landing page of the portfolio website.
    // Updated on - -
    // Updated Version - -
    // Input - none
    @GetMapping("/")
    public String home(Model model) {
        try {
            ClassPathResource htmlFile = new ClassPathResource("static/index.html");
            return StreamUtils.copyToString(htmlFile.getInputStream(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/personaldetails").
    //               Loads and returns all the personal details from the application.properties file.
    //               Used to serve the information for main landing page of the portfolio website.
    // Updated on - -
    // Updated Version - -
    // Input - none
    @GetMapping("/api/personaldetails")
    public PersonalDetail getPersonaldetails() {
        try {
            return personaldetail;
        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/skills").
    //               Loads and returns all the skills from the database.
    //               Used to serve the skills for main landing page of the portfolio website.
    // Updated on - -
    // Updated Version - -
    // Input - none
    @GetMapping("/api/skill")
    @ResponseBody
    public List<Skills> getAllStudents() {
        return skillrepository.findAll();
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/certificate").
    //               Loads and returns all the certificates from the database.
    //               Used to serve the certificates for education page of the portfolio website.
    // Updated on - -
    // Updated Version - -
    // Input - none
    @GetMapping("/api/certificate")
    @ResponseBody
    public List<Certificate> getCertificate() {
        return certificaterepository.findAllByOrderByIdAsc();
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/project").
    //               Loads and returns all the projects from the database.
    //               Used to serve the project for portfolio page of the portfolio website.
    // Updated on - -
    // Updated Version - -
    // Input - none
    @GetMapping("/api/project")
    @ResponseBody
    public List<Project> getProject() {
        return projectrepository.findAllByOrderByIdAsc();
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/project_image/{p_id}").
    //               Loads and returns all the images of the particular project from the database.
    //               Used to serve the project images for Project information page of the portfolio website.
    // Updated on - -
    // Updated Version - -
    // Input - Project Id
    @GetMapping("/api/project_image/{p_id}")
    @ResponseBody
    public List<Project_Image> getProjectImage(@PathVariable Long p_id) {
        return projectimagerepository.findBypId(p_id); // or repo.findById(id).get()
    }



    // Developer - Nimit Shah
    // Version - v0.0.0 - Beta
    // Developed on - 14/04/2025
    // Description - Handles HTTP POST requests to the root URL ("/api/saveContact").
    //               Get Data from the user and store in the database.
    // Updated on - -
    // Updated Version - -
    // Input - contact information
    @PostMapping("/api/saveContact")
    @ResponseBody
    public Contact saveContact(@RequestBody Contact contact) {
        return contactrepository.save(contact);
    }
}


