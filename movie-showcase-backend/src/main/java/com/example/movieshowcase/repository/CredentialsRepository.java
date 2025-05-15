package com.example.movieshowcase.repository;

import com.example.movieshowcase.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    Credentials findByUserUsername(String username);
}
