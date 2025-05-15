package com.example.movieshowcase.service;

import com.example.movieshowcase.Credentials;
import com.example.movieshowcase.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {

    private final CredentialsRepository credentialsRepository;

    @Autowired
    public CredentialService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Credentials findByUsername(String username) {
        return credentialsRepository.findByUserUsername(username);
    }

    public Credentials save(Credentials credentials) {
        return credentialsRepository.save(credentials);
    }
}
