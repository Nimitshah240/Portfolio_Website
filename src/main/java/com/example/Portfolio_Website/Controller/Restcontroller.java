package com.example.Portfolio_Website.Controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import com.example.Portfolio_Website.*;
import com.example.Portfolio_Website.DTO.*;
import com.example.Portfolio_Website.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Portfolio_Website.Emailing.sendEmail;

// Developer - Nimit Shah
// First-Version - v0.0.0 - Beta
// Current Version - v0.1.0
// Developed on - 14/04/2025
// Description - RestController file to handle all the HTTP Request to get different information.
// Updated on - -
// Updated Version - -
// Input - none
@RestController
public class Restcontroller {

    private PersonalDetail personaldetail;
    private final SkillServiceImpl skillServiceimpl;
    private final CertificateServiceImpl certificaterepositoryimpl;
    private final ProjectServiceImpl projectrepositoryimpl;
    private final Project_ImageServiceImpl projectimagerepositoryimpl;
    private final ContactServiceImpl contactrepositoryimpl;

    @Autowired
    public Restcontroller(PersonalDetail personaldetail, SkillServiceImpl skillServiceimpl, CertificateServiceImpl certificaterepositoryimpl, ProjectServiceImpl projectrepositoryimpl, Project_ImageServiceImpl projectimagerepositoryimpl, ContactServiceImpl contactrepositoryimpl) {
        this.personaldetail = personaldetail;
        this.skillServiceimpl = skillServiceimpl;
        this.certificaterepositoryimpl = certificaterepositoryimpl;
        this.projectrepositoryimpl = projectrepositoryimpl;
        this.projectimagerepositoryimpl = projectimagerepositoryimpl;
        this.contactrepositoryimpl = contactrepositoryimpl;
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/").
    //               Loads and returns the content of the static index.html file from classpath.
    //               Used to serve the main landing page of the portfolio website.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - none
    @GetMapping("/")
    @Cacheable("home")
    public String home(Model model) {
        try {
            ClassPathResource htmlFile = new ClassPathResource("static/index.html");
            return StreamUtils.copyToString(htmlFile.getInputStream(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/personaldetails").
    //               Loads and returns all the personal details from the application.properties file.
    //               Used to serve the information for main landing page of the portfolio website.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - none
    @GetMapping("/api/personaldetails")
    @Cacheable("personaldetail")
    public PersonalDetail getPersonaldetails() {
        try {
            return personaldetail;
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/skills").
    //               Loads and returns all the skills from the database.
    //               Used to serve the skills for main landing page of the portfolio website.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - none
    @GetMapping("/api/skill")
    @ResponseBody
    @Cacheable("skills")
    public List<Skills> getAllStudents() {
        try {
            return skillServiceimpl.findAll();
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/certificate").
    //               Loads and returns all the certificates from the database.
    //               Used to serve the certificates for education page of the portfolio website.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - none
    @GetMapping("/api/certificate")
    @ResponseBody
    @Cacheable("certificate")
    public List<Certificate> getCertificate() {
        try {
            return certificaterepositoryimpl.findAllByOrderByIdAsc();
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/project").
    //               Loads and returns all the projects from the database.
    //               Used to serve the project for portfolio page of the portfolio website.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - none
    @GetMapping("/api/project")
    @ResponseBody
    @Cacheable("project")
    public List<Project> getProject() {
        try {
            return projectrepositoryimpl.findAllByOrderByIdAsc();
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP GET requests to the root URL ("/api/project_image/{p_id}").
    //               Loads and returns all the images of the particular project from the database.
    //               Used to serve the project images for Project information page of the portfolio website.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - Project Id
    @GetMapping("/api/project_image/{p_id}")
    @ResponseBody
    @Cacheable(value = "projectImage", key = "#p_id")
    public List<Project_Image> getProjectImage(@PathVariable Long p_id) {
        try {
            return projectimagerepositoryimpl.findBypId(p_id); // or repo.findById(id).get()
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }

    // Developer - Nimit Shah
    // First-Version - v0.0.0 - Beta
    // Current Version - v0.1.0
    // Developed on - 14/04/2025
    // Description - Handles HTTP POST requests to the root URL ("/api/saveContact").
    //               Get Data from the user and store in the database.
    // Updated on - 17/04/2025
    // Update - Added catch block with emailing on error.
    // Updated Version - v0.1.0
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - contact information
    @PostMapping("/api/saveContact")
    @ResponseBody
    public Contact saveContact(@RequestBody Contact contact) {
        try {
            return contactrepositoryimpl.save(contact);
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            throw new RuntimeException(e);
        }
    }
}


