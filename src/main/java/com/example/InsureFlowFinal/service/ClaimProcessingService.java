package com.example.InsureFlowFinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InsureFlowFinal.entity.ClaimSubmission;
import com.example.InsureFlowFinal.exception.BusinessValidationException;
import com.example.InsureFlowFinal.exception.ResourceNotFoundException;
import com.example.InsureFlowFinal.repository.ClaimSubmissionRepository;

@Service
public class ClaimProcessingService {

    @Autowired
    private ClaimSubmissionRepository repo;

    // CREATE CLAIM
    public ClaimSubmission fileClaim(ClaimSubmission claim) {

        if (claim.getIncidentDate().isAfter(LocalDate.now())) {
            throw new BusinessValidationException("Incident date cannot be in future");
        }

        claim.setClaimStatus("SUBMITTED");

        return repo.save(claim);
    }

    // GET ALL
    public List<ClaimSubmission> getAllClaims() {
        return repo.findAll();
    }

    // ADJUDICATE CLAIM
    public ClaimSubmission adjudicate(Long id, String status) {

        ClaimSubmission claim = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim not found with id: " + id));

        claim.setClaimStatus(status);

        return repo.save(claim);
    }

    // DELETE CLAIM
    public void deleteClaim(Long id) {

        ClaimSubmission claim = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim not found with id: " + id));

        repo.delete(claim);
    }
}