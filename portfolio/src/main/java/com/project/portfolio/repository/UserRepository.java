package com.project.portfolio.repository;

import com.project.portfolio.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // MongoDB auto-magically creates this query logic
    Optional<User> findByEmail(String email);
}