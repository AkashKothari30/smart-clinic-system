package com.cfs.smart_clinic_system.service;

import com.cfs.smart_clinic_system.models.Appointment;
import com.cfs.smart_clinic_system.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByDoctorAndDate(Long doctorId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return appointmentRepository.findByDoctorIdAndAppointmentTimeBetween(
                doctorId,
                startOfDay,
                endOfDay
        );
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}