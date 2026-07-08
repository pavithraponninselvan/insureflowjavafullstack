package com.example.InsureFlowFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import com.example.InsureFlowFinal.entity.ClaimSubmission;

public interface ClaimSubmissionRepository extends JpaRepository<ClaimSubmission, Long> {

    List<ClaimSubmission> findByPolicyId(Long policyId);

    List<ClaimSubmission> findByClaimantId(Long claimantId);

    @Query("SELECT c FROM ClaimSubmission c WHERE c.claimStatus IN ('SUBMITTED','UNDER_REVIEW')")
    List<ClaimSubmission> findActiveReviewBacklog();
}