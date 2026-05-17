package com.project.portfolio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username; // 'name' badhila 'username' nu update aagi irukku
    private String email;
    private String password;
    private String role;
}