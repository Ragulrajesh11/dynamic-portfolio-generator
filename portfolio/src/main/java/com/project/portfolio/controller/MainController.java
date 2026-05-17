package com.project.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/register")
    public String register() { return "register"; }

    @GetMapping("/template_selection")
    public String templateSelection() { return "template_selection"; }

    @GetMapping("/portfolio_form")
    public String portfolioForm() { return "portfolio_form"; }

    @GetMapping("/success")
    public String success() { return "success"; }
}