package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/patient")
public class PatientController {
   @Autowired
   private PatientService patientService;

   @RequestMapping("/patients")
   public List<Patient> getPatients() {
      return this.patientService.getPatients();
   }

   @RequestMapping("/{id}")
   public Patient getPatient(@PathVariable("id") long id) {
      return this.patientService.getPatient(id);
   }

   @RequestMapping(method = RequestMethod.POST, value = "/add")
   public void addPatient(@RequestBody Patient patient) {
      this.patientService.addPatient(patient);
   }

   @RequestMapping(method = RequestMethod.PUT, value = "/update")
   public void updatePatient(@RequestBody Patient patient) {
      this.patientService.updatePatient(patient);
   }

   @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
   public void deletePatient(@PathVariable("id") long id) {
      this.patientService.deletePatient(id);
   }

   @RequestMapping("/username/{username}")
   public Patient getPatientByUsername(@PathVariable("username") String username) {
      return this.patientService.findPatientByUsername(username);
   }

}