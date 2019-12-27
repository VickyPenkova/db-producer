package com.informatics.webservices.service;

import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
   @Autowired
   private PatientRepository patientRepository;

   public List<Patient> getPatients() {
      List<Patient> patientsList = new ArrayList<>();
      patientRepository.findAll().forEach(course -> patientsList.add(course));

      return patientsList;
   }

   public Patient getPatient(long id) {
      Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
      return patient;
   }

   public void addPatient(Patient patient) {
      patientRepository.save(patient);
   }

   public void updatePatient(long id, Patient patient) {
      patientRepository.save(patient);
   }

   public void deletePatient(long id) {
      Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
      patientRepository.delete(patient);
   }

   public Patient findPatientByUsername(String username) {
      return patientRepository.findPatientByUsername(username);
   }
}
