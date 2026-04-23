package com.cfs.smart_clinic_system.repository;



import com.cfs.smart_clinic_system.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
    Patient findByEmailOrPhone(String email,String phone);
}