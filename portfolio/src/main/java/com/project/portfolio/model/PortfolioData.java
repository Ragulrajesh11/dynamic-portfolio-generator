package com.project.portfolio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "portfolio_data") // MongoDB collection name
@Getter
@Setter
public class PortfolioData {

    @Id // Spring Data Id annotation
    private String id; // Integer-ku badhila String dhaan MongoDB standard

    private String fullName;

    // MongoDB-la columnDefinition thevai illa, automatic-ah handle aagum
    private String bio;
    private String skills;
    private String projects;

    private Integer templateId;

    @DBRef // JPA-la ManyToOne maari MongoDB-la DBRef use pannalam
    private User user;

}