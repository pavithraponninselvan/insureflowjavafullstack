package com.example.InsureFlowFinal.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.InsureFlowFinal.entity.SystemAccount;
import com.example.InsureFlowFinal.repository.SystemAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SystemAccountRepository repository;

    public CustomUserDetailsService(SystemAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        SystemAccount user = repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found"));

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}