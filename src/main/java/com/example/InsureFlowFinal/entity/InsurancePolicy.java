package com.example.InsureFlowFinal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance_policy")
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private Long accountId;

    private String coverageType;

    private BigDecimal premiumAmount;

    private BigDecimal maxCoverageLimit;

    private BigDecimal remainingLimit;

    private String policyStatus;

    private LocalDate effectiveDate;

    private LocalDate expiryDate;

    public InsurancePolicy() {
    }

    public InsurancePolicy(Long id, String policyNumber, Long accountId,
            String coverageType, BigDecimal premiumAmount,
            BigDecimal maxCoverageLimit, BigDecimal remainingLimit,
            String policyStatus, LocalDate effectiveDate,
            LocalDate expiryDate) {

        this.id = id;
        this.policyNumber = policyNumber;
        this.accountId = accountId;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
        this.maxCoverageLimit = maxCoverageLimit;
        this.remainingLimit = remainingLimit;
        this.policyStatus = policyStatus;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public BigDecimal getMaxCoverageLimit() {
        return maxCoverageLimit;
    }

    public void setMaxCoverageLimit(BigDecimal maxCoverageLimit) {
        this.maxCoverageLimit = maxCoverageLimit;
    }

    public BigDecimal getRemainingLimit() {
        return remainingLimit;
    }

    public void setRemainingLimit(BigDecimal remainingLimit) {
        this.remainingLimit = remainingLimit;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}