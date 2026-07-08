package com.example.InsureFlowFinal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Table(name = "claim_submission")
public class ClaimSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;

    private Long policyId;

    private Long claimantId;

    private LocalDate incidentDate;

    private String incidentDescription;

    private BigDecimal requestedPayout;

    private BigDecimal approvedPayout;

    private String claimStatus;

    public ClaimSubmission() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public Long getClaimantId() {
        return claimantId;
    }

    public void setClaimantId(Long claimantId) {
        this.claimantId = claimantId;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentDescription() {
        return incidentDescription;
    }

    public void setIncidentDescription(String incidentDescription) {
        this.incidentDescription = incidentDescription;
    }

    public BigDecimal getRequestedPayout() {
        return requestedPayout;
    }

    public void setRequestedPayout(BigDecimal requestedPayout) {
        this.requestedPayout = requestedPayout;
    }

    public BigDecimal getApprovedPayout() {
        return approvedPayout;
    }

    public void setApprovedPayout(BigDecimal approvedPayout) {
        this.approvedPayout = approvedPayout;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
