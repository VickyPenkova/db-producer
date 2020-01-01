package com.informatics.webservices.repository;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
   List<Appointment> getAppointmentsByDoctorId(long doctorId);
   List<Appointment> getAppointmentsByPatient(Patient patient);
   List<Appointment> getAppointmentsByPatientId(long patientId);
   List<Appointment> getAppointmentsByDateOfAppointment(Date dateOfAppointment);
}