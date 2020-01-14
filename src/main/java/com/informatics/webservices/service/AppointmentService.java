package com.informatics.webservices.service;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.repository.AppointmentRepository;
import com.informatics.webservices.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

   @Autowired
   AppointmentRepository appointmentRepository;


   public List<Appointment> getAppointments() {
      List<Appointment> appointmentsList = new ArrayList<>(appointmentRepository.findAll());

      return appointmentsList;
   }

   public Appointment getAppointment(long id) {
      Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));
      return appointment;
   }

   public void addAppointment(Appointment appointment) {
      /**
       * Any patient can make an appointment with any doctor(even if it's not his/hers GP)
       */

      Appointment app= appointment;

      appointmentRepository.save(app);
   }

   public void updateAppointment(Appointment appointment) {
      appointmentRepository.save(appointment);
   }

   public void deleteAppointment(long id) {
      Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));
      appointmentRepository.delete(appointment);
   }

   public List<Appointment> getAppointmentsByDoctorId(long doctorId) {
      return appointmentRepository.getAppointmentsByDoctorId(doctorId);
   }

   public List<Appointment> getAppointmentsByDoctorUsername(String username) {
      System.out.println(appointmentRepository.getAppointmentsByDoctorUsername(username));
      return appointmentRepository.getAppointmentsByDoctorUsername(username);
   }


   public List<Appointment> getAppointmentsByPatientId(long patientId) {
      return appointmentRepository.getAppointmentsByPatientId(patientId);
   }

   public List<Appointment> getAppointmentsByPatientUsername(String username) {

      List<Appointment> appointments = appointmentRepository.getAppointmentsByPatientUsername(username);
      return appointments;
   }

   public List<Appointment> getAppointmentsByDateOfAppointment(Date dateOfAppointment) {
      return appointmentRepository.getAppointmentsByDateOfAppointment(dateOfAppointment);
   }



   public List<Patient> findPatientsByDiagnosis(String diagnosis){

      List<Appointment> appointments = getAppointments();
      List<Patient> patients = new ArrayList<>();

      for (Appointment appointment:appointments) {

         if(appointment.getDiagnosis().equals(diagnosis))
            patients.add(appointment.getPatient());

      }

      return patients;

   }

}
