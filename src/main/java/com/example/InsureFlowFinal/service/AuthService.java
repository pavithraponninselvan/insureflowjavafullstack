package com.example.InsureFlowFinal.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.InsureFlowFinal.entity.SystemAccount;
import com.example.InsureFlowFinal.repository.SystemAccountRepository;

@Service
public class AuthService {

    private final PasswordEncoder encoder;
    private final SystemAccountRepository repository;

    public AuthService(PasswordEncoder encoder,
                       SystemAccountRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    public SystemAccount register(SystemAccount user) {

        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setIsActive(true);

        return repository.save(user);
    }

}
