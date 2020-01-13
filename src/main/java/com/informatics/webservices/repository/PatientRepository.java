package com.informatics.webservices.repository;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
   Patient findPatientByUsername(String username);
   Doctor findPatientByDoctorGpUsername(String username);
   Patient findPatientByAppointmentsIn(List<Appointment> appointments);
}
