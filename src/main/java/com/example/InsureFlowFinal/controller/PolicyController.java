package com.example.InsureFlowFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsureFlowFinal.entity.InsurancePolicy;
import com.example.InsureFlowFinal.service.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('UNDERWRITER') or hasRole('INSURANCE_MANAGER')")
    public ResponseEntity<InsurancePolicy> createPolicy(
            @RequestBody InsurancePolicy policy) {

        InsurancePolicy savedPolicy = service.addPolicy(policy);

        return new ResponseEntity<>(savedPolicy, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('UNDERWRITER') or hasRole('INSURANCE_MANAGER')")
    public ResponseEntity<List<InsurancePolicy>> getAllPolicies() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/my-policies")
    @PreAuthorize("hasRole('POLICYHOLDER')")
    public ResponseEntity<List<InsurancePolicy>> getMyPolicies(
            Authentication authentication) {
        return ResponseEntity.ok(service.getAll());
    }

    @PatchMapping("/{id}/activate")
    @PreAuthorize("hasRole('UNDERWRITER') or hasRole('INSURANCE_MANAGER')")
    public ResponseEntity<InsurancePolicy> activatePolicy(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.activatePolicy(id));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('UNDERWRITER') or hasRole('INSURANCE_MANAGER')")
    public ResponseEntity<String> updatePolicy(
            @PathVariable Long id,
            @RequestBody InsurancePolicy policy) {

        return ResponseEntity.ok(service.updatePolicy(id, policy));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('UNDERWRITER') or hasRole('INSURANCE_MANAGER')")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {

        service.deletePolicy(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}