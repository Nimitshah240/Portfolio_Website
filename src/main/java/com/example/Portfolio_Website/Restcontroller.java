package com.example.Portfolio_Website;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class Restcontroller {

    @GetMapping("/")
    public String home()  {
        try {
            ClassPathResource htmlFile = new ClassPathResource("static/index.html");
            return StreamUtils.copyToString(htmlFile.getInputStream(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
