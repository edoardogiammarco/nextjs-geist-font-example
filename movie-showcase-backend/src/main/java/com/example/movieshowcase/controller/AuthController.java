package com.example.movieshowcase.controller;

import com.example.movieshowcase.Credentials;
import com.example.movieshowcase.User;
import com.example.movieshowcase.service.CredentialService;
import com.example.movieshowcase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final CredentialService credentialService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, CredentialService credentialService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.credentialService = credentialService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        Credentials credentials = user.getCredentials();
        credentials.setPasswordHash(passwordEncoder.encode(credentials.getPasswordHash()));
        user.setCredentials(credentials);
        credentials.setUser(user);
        userService.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Additional login and token generation endpoints can be added here
}
