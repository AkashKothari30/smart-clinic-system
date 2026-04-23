package com.cfs.smart_clinic_system.service;

import com.cfs.smart_clinic_system.models.Prescription;
import com.cfs.smart_clinic_system.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }
}