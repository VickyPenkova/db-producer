package com.informatics.webservices.service;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

      appointmentRepository.save(appointment);
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


   public List<Appointment> getAppointmentsByPatientId(long patientId) {
      return appointmentRepository.getAppointmentsByPatientId(patientId);
   }

   public List<Appointment> getAppointmentsByDateOfAppointment(Date dateOfAppointment) {
      return appointmentRepository.getAppointmentsByDateOfAppointment(dateOfAppointment);
   }

}
