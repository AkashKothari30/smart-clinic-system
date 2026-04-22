package com.cfs.smart_clinic_system.repository;

import com.cfs.smart_clinic_system.models.Appointment;
import com.cfs.smart_clinic_system.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByAppointmentTimeBetween(LocalDateTime start, LocalDateTime end);
}