package com.project.portfolio.controller;

import com.project.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private EmailService emailService;

    // Dynamic-ah classpath templates file-ah read panna idhu mukhkiyam thala
    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/generate")
    public String generatePortfolio(
            @RequestParam String fullName,
            @RequestParam String title,
            @RequestParam String about,
            @RequestParam String projectName,
            @RequestParam String projectDesc,
            @RequestParam String skills,
            @RequestParam String linkedin,
            @RequestParam String github,
            @RequestParam String instagram,
            @RequestParam String userEmail,
            @RequestParam String templateId) {

        System.out.println("Processing dynamic portfolio generation for: " + fullName + " using Template ID: " + templateId);

        try {
            // 1. User select panna templateId vachu exact HTML file name-ah ready panrom (e.g., template1.html)
            String templateName = "template" + templateId + ".html";
            Resource resource = resourceLoader.getResource("classpath:templates/" + templateName);

            // 2. Resource input stream valiyaa html file kulla ulla full internal CSS and code-ah string-ah mathrom
            String htmlContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

            // 3. HTML templates-la namma pottu vechurukura bracket placeholders-ah user data vachu target panni replace panrom
            htmlContent = htmlContent.replace("[fullName]", fullName)
                    .replace("[title]", title)
                    .replace("[about]", about)
                    .replace("[projectName]", projectName)
                    .replace("[projectDesc]", projectDesc)
                    .replace("[skills]", skills)
                    .replace("[linkedin]", linkedin)
                    .replace("[github]", github)
                    .replace("[instagram]", instagram);

            // 4. Dynamic internal CSS embedded content-ah direct-ah user email-ku push panrom
            emailService.sendHtmlMail(userEmail, "Your Professional Web Portfolio is Ready! [TID: 0" + templateId + "]", htmlContent);
            System.out.println("Success! Mail dispatched using custom theme layout: " + templateName);

        } catch (Exception e) {
            System.out.println("Error while parsing dynamic html template file: " + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/success";
    }
}