package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Doctor;
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

   @RequestMapping("/doctors/{id}")
   public Doctor getDoctor(@PathVariable("id") int id) {
      return doctorService.getDoctor(id);
   }

   @RequestMapping(method = RequestMethod.POST, value = "add")
   public void addDoctor(@RequestBody Doctor doctor) {
      doctorService.addDoctor(doctor);
   }

   @RequestMapping(method = RequestMethod.PUT, value = "/doctors")
   public void updateDoctor(@RequestBody Doctor doctor) {
      doctorService.addDoctor(doctor);
   }

   @RequestMapping(method = RequestMethod.DELETE, value = "/doctors/{id}")
   public void deleteDoctor(@PathVariable("id") int id) {
      doctorService.deleteDoctor(id);
   }

   @RequestMapping("/username/{username}")
   public Doctor getDoctorsByUserName(@PathVariable("username") String username) {
      return doctorService.findDoctorByUsername(username);
   }

}
