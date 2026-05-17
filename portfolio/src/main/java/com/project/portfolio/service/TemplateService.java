package com.project.portfolio.service;

import com.project.portfolio.model.PortfolioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class TemplateService {

    @Autowired
    private TemplateEngine templateEngine;

    public String generateHtml(PortfolioData data) {
        // Thymeleaf context-la details-ah set pandrom
        Context context = new Context();
        context.setVariable("fullName", data.getFullName());
        context.setVariable("bio", data.getBio());
        context.setVariable("skills", data.getSkills());
        context.setVariable("projects", data.getProjects());

        // Template ID-ah vachu entha file-ah use pannanum nu decide pandrom
        String templateName = "template" + data.getTemplateId(); // e.g., template1

        // Merge data with HTML template
        return templateEngine.process(templateName, context);
    }
}