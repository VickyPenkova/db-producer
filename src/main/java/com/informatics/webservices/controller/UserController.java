package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.service.DoctorService;
import com.informatics.webservices.service.PatientService;
import com.informatics.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
   @Autowired
   private UserService userService;

   @Autowired
   private DoctorService doctorService;

   @Autowired
   private PatientService patientService;

   @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
   public Object getUser(@PathVariable("username") String username){
         return this.userService.getUserByUsername(username);
   }

   @RequestMapping(method = RequestMethod.GET, value="/updateLoginAttempt/{username}/{loginAttempt}")
   public void updateUserLoginAttempt(@PathVariable String username, @PathVariable Integer loginAttempt){
      Object o = this.userService.getUserByUsername(username);
      if (o.getClass() == Patient.class){
         Patient p = this.patientService.findPatientByUsername(username);
         p.setLoginAttempt(loginAttempt);
      }else if(o.getClass() == Doctor.class){
         Doctor d = this.doctorService.findDoctorByUsername(username);
         d.setLoginAttempt(loginAttempt);
      }
   }

   @RequestMapping(method = RequestMethod.GET, value = "/update/{username}/{authToken}")
   public void updateUserAuthToken(@PathVariable String username, @PathVariable String authToken){
      userService.updateUserAuthToken(username, authToken);
   }

}
