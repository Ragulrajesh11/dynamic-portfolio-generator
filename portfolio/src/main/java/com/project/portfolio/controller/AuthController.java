package com.project.portfolio.controller;

import com.project.portfolio.model.User;
import com.project.portfolio.service.AuthService;
import com.project.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        authService.registerUser(user);
        try {
            emailService.sendSuccessMail(user.getEmail(), user.getUsername());
        } catch (Exception e) {
            System.out.println("Welcome mail failed, but data saved in DB.");
        }
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        System.out.println("Login request received for: " + email);
        User user = authService.loginUser(email, password);

        if (user != null) {
            System.out.println("Login Success! Redirecting to dashboard...");
            return "redirect:/template_selection";
        } else {
            System.out.println("Login Failed! Mismatch credentials.");
            return "redirect:/login?error=true";
        }
    }
}