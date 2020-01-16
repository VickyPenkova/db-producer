package com.informatics.webservices.service;

import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
@Slf4j
public class UserService {
   @Autowired
   private DoctorService doctorService;

   @Autowired
   private PatientService patientService;

   public Object getUserByUsername(String username){
      System.out.println("Searching for user...");
      Doctor d = doctorService.findDoctorByUsername(username);
      if (d != null){
         return d;
      }

      Patient p = patientService.findPatientByUsername(username);
      return p;
   }

   public void updateUserAuthToken(String username, String token){
      Object u = getUserByUsername(username);
      if (u.getClass().equals(Doctor.class)){
         ((Doctor) u).setAuthToken(token);
      }
      else if(u.getClass().equals(Patient.class)){
         ((Patient) u).setAuthToken(token);
      }
   }
}
