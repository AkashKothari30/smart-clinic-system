package com.cfs.smart_clinic_system.controller;

import com.cfs.smart_clinic_system.models.Doctor;
import com.cfs.smart_clinic_system.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getDoctors(@RequestParam(required = false) String specialty) {
        if (specialty != null && !specialty.isBlank()) {
            return doctorService.getDoctorsBySpecialty(specialty);
        }
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        if (!"1234".equals(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid token");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("available", true);
        response.put("message", "Doctor availability fetched successfully");

        return ResponseEntity.ok(response);
    }
}