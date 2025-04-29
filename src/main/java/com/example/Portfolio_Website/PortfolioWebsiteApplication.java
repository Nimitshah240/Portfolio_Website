package com.example.Portfolio_Website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import static com.example.Portfolio_Website.Emailing.sendEmail;

@SpringBootApplication
@EnableScheduling
public class PortfolioWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioWebsiteApplication.class, args);
    }

    // Developer - Nimit Shah
    // First-Version - v0.1.0
    // Current Version - v0.1.0
    // Developed on - 17/04/2025
    // Description - This method use to call own api in every 5 minute, TO KEEP SERVER AND DB ACTIVE.
    // after testing 5 min is the maximum time for db call, so do not increase time from 5 minutes.
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Passing method name in exception email.
    // Input - none
    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void callApiPeriodically() {
        try {
            int timeout = 20000;
            SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
            clientHttpRequestFactory.setConnectTimeout(timeout);
            clientHttpRequestFactory.setReadTimeout(timeout);
            RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
            String url1 = "https://nimitshah.onrender.com//api/project_image/999";
            ResponseEntity<String> response1 = restTemplate.getForEntity(url1, String.class);
        } catch (Exception e) {
            sendEmail("nimitshah240@gmail.com", "Error", e.getMessage(), e.getStackTrace()[0].getMethodName());
            System.err.println("API call failed: " + e.getMessage());
        }
    }
}
