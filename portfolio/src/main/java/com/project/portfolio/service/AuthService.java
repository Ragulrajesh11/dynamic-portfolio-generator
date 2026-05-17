package com.project.portfolio.service;

import com.project.portfolio.model.User;
import com.project.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User loginUser(String email, String password) {
        // 1. Email vachu user-ah thedurom
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // 2. Password match aaguthu-nu check pandrom
            // matches(rawPassword, encodedPassword)
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user; // Password match aana user object-ah tharuvom
            }
        }
        return null; // Email illana illa password thappa iruntha null
    }

}