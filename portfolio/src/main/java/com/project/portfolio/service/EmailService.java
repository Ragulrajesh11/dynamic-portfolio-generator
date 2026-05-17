package com.project.portfolio.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // 1. Register pannumpodhu vara Simple Welcome Mail
    public void sendSuccessMail(String toEmail, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Portfoliify!");
        message.setText("Hi " + username + ",\n\nYour account has been successfully created. " +
                "Now you can log in and build your stunning portfolio designs.\n\nBest Regards,\nRagul - Portfoliify Team");

        mailSender.send(message);
        System.out.println("Welcome mail sent to: " + toEmail);
    }

    // 2. Portfolio Design-ah HTML format-la anuppum Mukhkiyamaana method
    public void sendHtmlMail(String to, String subject, String htmlBody) {
        try {
            // MimeMessage dhaan HTML-ah support pannum
            MimeMessage message = mailSender.createMimeMessage();

            // Helper class to set email properties easily
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);

            // Inga 'true' nu kudutha dhaan, andha HTML tags-ah design-ah mathum
            helper.setText(htmlBody, true);

            mailSender.send(message);
            System.out.println("Portfolio Design sent successfully to: " + to);

        } catch (MessagingException e) {
            System.out.println("Error while sending HTML mail: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}