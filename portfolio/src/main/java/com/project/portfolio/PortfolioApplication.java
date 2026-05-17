package com.project.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        UserDetailsServiceAutoConfiguration.class
})
public class PortfolioApplication {
    public static void main(String[] args) {
        System.setProperty("spring.autoconfigure.exclude",
                "org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration");
        SpringApplication.run(PortfolioApplication.class, args);
    }
}