package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.service.DoctorService;
import com.informatics.webservices.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
   @Autowired
   private DoctorService doctorService;

   @Autowired
   private PatientService patientService;

   @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
   public Object getUser(@PathVariable("username") String username){

         System.out.println("Searching for user...");
         Doctor d = doctorService.findDoctorByUsername(username);
         if (d != null){
            return d;
         }

         Patient p = patientService.findPatientByUsername(username);
         return p;
   }
}
