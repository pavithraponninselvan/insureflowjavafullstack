package com.example.InsureFlowFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InsureFlowFinal.entity.InsurancePolicy;
import com.example.InsureFlowFinal.exception.BusinessValidationException;
import com.example.InsureFlowFinal.exception.ResourceNotFoundException;
import com.example.InsureFlowFinal.repository.InsurancePolicyRepository;

@Service
public class PolicyService {

    @Autowired
    InsurancePolicyRepository repo;

    public InsurancePolicy addPolicy(InsurancePolicy policy) {

        if (policy.getPremiumAmount().doubleValue() < 0) {
            throw new BusinessValidationException("Premium amount cannot be negative.");
        }

        if (policy.getMaxCoverageLimit().doubleValue() < 0) {
            throw new BusinessValidationException("Maximum coverage limit cannot be negative.");
        }

        if (policy.getRemainingLimit().doubleValue() < 0) {
            throw new BusinessValidationException("Remaining limit cannot be negative.");
        }

        if (policy.getEffectiveDate().isAfter(policy.getExpiryDate())) {
            throw new BusinessValidationException("Effective date cannot be after expiry date.");
        }

        return repo.save(policy);
    }

    public List<InsurancePolicy> getAll() {
        return repo.findAll();
    }

    public InsurancePolicy getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy not found with id : " + id));
    }

    public String updatePolicy(Long id, InsurancePolicy policy) {

        InsurancePolicy old = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy not found with id : " + id));
//404 Not found-status code
        old.setPolicyNumber(policy.getPolicyNumber());
        old.setAccountId(policy.getAccountId());
        old.setCoverageType(policy.getCoverageType());
        old.setPremiumAmount(policy.getPremiumAmount());
        old.setMaxCoverageLimit(policy.getMaxCoverageLimit());
        old.setRemainingLimit(policy.getRemainingLimit());
        old.setPolicyStatus(policy.getPolicyStatus());
        old.setEffectiveDate(policy.getEffectiveDate());
        old.setExpiryDate(policy.getExpiryDate());

        repo.save(old);

        return "Policy updated successfully";
    }

    public String deletePolicy(Long id) {

        InsurancePolicy policy = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy not found with id : " + id));

        repo.delete(policy);

        return "Policy deleted successfully";
    }
    public InsurancePolicy activatePolicy(Long id) {

    InsurancePolicy policy = repo.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Policy not found"));

    policy.setPolicyStatus("ACTIVE");

    return repo.save(policy);
}
}
