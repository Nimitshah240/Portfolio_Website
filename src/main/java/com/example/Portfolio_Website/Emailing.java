package com.example.Portfolio_Website;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailing {

    public static final String FROM_EMAIL = "nimitshah240@gmail.com";
    public static final String PASSWORD = "wmpz pkdn tksq atqu\n"; // Use App Password if using Gmail

    // Developer - Nimit Shah
    // First-Version - v0.1.0
    // Current Version - v0.1.0
    // Developed on - 17/04/2025
    // Description - This method is used to send email if any error/exception occurs.
    // It will send email to nimitshah240@gmail.com.
    // Updated on - 29/04/2025
    // Updated Version - v0.1.3
    // Update - Sharing method name in exception email as subject.
    // Input - email, subject and message, methodname.
    public static void sendEmail(String toEmail, String subject, String body, String methodname) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject + " in " + methodname + " method");
            message.setText(body);
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
