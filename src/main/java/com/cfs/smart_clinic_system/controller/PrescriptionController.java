package com.cfs.smart_clinic_system.controller;


import com.cfs.smart_clinic_system.models.Prescription;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final List<Prescription> prescriptions = new ArrayList<>();

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    @PostMapping
    public Prescription addPrescription(@RequestBody Prescription prescription) {
        prescriptions.add(prescription);
        return prescription;
    }
}
