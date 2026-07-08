package com.example.InsureFlowFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InsureFlowFinal.entity.SystemAccount;

public interface SystemAccountRepository extends JpaRepository<SystemAccount, Long> {

    Optional<SystemAccount> findByEmail(String email);

}