package com.cfs.smart_clinic_system.controller;

import com.cfs.smart_clinic_system.models.Prescription;
import com.cfs.smart_clinic_system.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/{token}")
    public ResponseEntity<?> addPrescription(
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {

        // simple token validation
        if (!"1234".equals(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid token");
        }

        Prescription saved = prescriptionService.addPrescription(prescription);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}