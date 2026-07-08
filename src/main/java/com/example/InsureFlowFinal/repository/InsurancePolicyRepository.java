package com.example.InsureFlowFinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InsureFlowFinal.entity.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

    List<InsurancePolicy> findByAccountId(Long accountId);

    Optional<InsurancePolicy> findByPolicyNumber(String policyNumber);

}