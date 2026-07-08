package com.example.InsureFlowFinal.controller;
import java.util.List;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.InsureFlowFinal.entity.ClaimSubmission;
import com.example.InsureFlowFinal.service.ClaimProcessingService;

@RestController
//@PreAuthorize("hasRole('POLICYHOLDER')")can be used here if a person has access to all methods
@RequestMapping("/api/v1/claims")
public class ClaimController {
    private final ClaimProcessingService service;
    public ClaimController(ClaimProcessingService service) {
        this.service = service;
    }
    // CREATE CLAIM
    @PostMapping
    @PreAuthorize("hasRole('POLICYHOLDER')")
    public ResponseEntity<ClaimSubmission> create(@RequestBody ClaimSubmission claim) {
        return new ResponseEntity<>(service.fileClaim(claim), HttpStatus.CREATED);
    }
    // GET ALL CLAIMS
    @GetMapping
    @PreAuthorize("hasRole('INSURANCE_MANAGER') or hasRole('UNDERWRITER')")
    public ResponseEntity<List<ClaimSubmission>> getAll() {
        return ResponseEntity.ok(service.getAllClaims());
    }
    // ADJUDICATE CLAIM
    @PatchMapping("/{id}/adjudicate")
    @PreAuthorize("hasRole('INSURANCE_MANAGER')")
    public ResponseEntity<ClaimSubmission> adjudicate(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(service.adjudicate(id, status));
    }
    // DELETE CLAIM
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('INSURANCE_MANAGER') or hasRole('POLICYHOLDER')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteClaim(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}