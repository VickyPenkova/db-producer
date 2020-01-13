package com.informatics.webservices.repository;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findDoctorByUsername(String username);
    Doctor findDoctorByAppointmentsIn(List<Appointment> appointments);
}
