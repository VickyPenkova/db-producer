package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {

   @Autowired
   private DoctorService doctorService;

   @RequestMapping("/doctors")
   public List<Doctor> getDoctors() {
      return doctorService.getDoctors();
   }

   @RequestMapping("/{id}")
   public Doctor getDoctor(@PathVariable("id") long id) {
      return doctorService.getDoctor(id);
   }

   @RequestMapping(method = RequestMethod.POST, value = "/add")
   public void addDoctor(@RequestBody Doctor doctor) {
      doctorService.addDoctor(doctor);
   }

   @RequestMapping(method = RequestMethod.PUT, value = "/update")
   public void updateDoctor(@RequestBody Doctor doctor) {
      doctorService.updateDoctor(doctor);
   }

   @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
   public void deleteDoctor(@PathVariable("id") long id) {
      doctorService.deleteDoctor(id);
   }

   @RequestMapping("/username/{username}")
   public Doctor getDoctorsByUserName(@PathVariable("username") String username) {
      return doctorService.findDoctorByUsername(username);
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}/patients")
   public List<Patient> getPatientsByDoctorId(@PathVariable long id){
      return this.doctorService.getDoctor(id).getPatients();
   }

}
