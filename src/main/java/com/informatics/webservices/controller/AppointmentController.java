package com.informatics.webservices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.service.AppointmentService;
import net.minidev.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
   @Autowired
   private AppointmentService appointmentService;

   @RequestMapping("/appointments")
   public List<Appointment> getAppointments() {
      return appointmentService.getAppointments();
   }

   @RequestMapping("/{id}")
   public Appointment getAppointment(@PathVariable("id") int id) {
      Appointment appointment = appointmentService.getAppointment(id);
      return appointment;
   }
   @RequestMapping(method = RequestMethod.POST, value = "/add")
   public void addAppointment(@RequestBody Appointment appointment) {

      appointmentService.addAppointment(appointment);
   }

   @RequestMapping(method = RequestMethod.PUT, value = "/update", headers = "Accept=application/json")
   public void updateAppointment(@RequestBody Appointment appointment) {
      appointmentService.updateAppointment(appointment);
   }

   @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
   public void deleteAppointment(@PathVariable("id") long id) {
      appointmentService.deleteAppointment(id);
   }

//   @RequestMapping(method = RequestMethod.GET, value = "/appointments/doctor/{id}")
//   public List<Appointment> getAppointmentsByDoctorId(@PathVariable("id") long doctorId){
//
//      return appointmentService.getAppointmentsByDoctorId(doctorId);
//   }

   @RequestMapping(method = RequestMethod.GET, value = "/appointments/doctor/{username}")
   public List<Appointment> getAppointmentsByDoctorUsername(@PathVariable("username") String username){

      return appointmentService.getAppointmentsByDoctorUsername(username);
   }

//   @RequestMapping(method = RequestMethod.GET, value = "/appointments/patient/{id}")
//   public List<Appointment> getAppointmentsByPatientId(@PathVariable("id") long id){
//      return appointmentService.getAppointmentsByPatientId(id);
//   }

   @RequestMapping(method = RequestMethod.GET, value = "/appointments/patient/{username}")
   public List<Appointment> getAppointmentsByPatientUsername(@PathVariable("username") String username){
      List<Appointment> appointments = appointmentService.getAppointmentsByPatientUsername(username);

  //    System.out.println(appointments);

      return appointments;
   }


      @RequestMapping(method = RequestMethod.GET, value = "/appointments/patients/{diagnosis}")
   public List<Patient> getPatientsByDiagnosis(@PathVariable("diagnosis") String diagnosis){

         System.out.println("=================GOT DIAGNOSIS==================");
      System.out.println(diagnosis);

      List<Patient> patients = appointmentService.findPatientsByDiagnosis(diagnosis);


      return patients;
   }


   // TODO: TEST!
   @RequestMapping(method = RequestMethod.GET, value = "/appointments/byDate")
   public List<Appointment> getAppointmentsByDateOfAppointment(@RequestBody Date date){
      return appointmentService.getAppointmentsByDateOfAppointment(date);
   }
}
