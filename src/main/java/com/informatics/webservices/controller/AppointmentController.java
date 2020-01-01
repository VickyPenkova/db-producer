package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
      return appointmentService.getAppointment(id);
   }

   @RequestMapping(method = RequestMethod.POST, value = "/add")
   public void addAppointment(@RequestBody Appointment appointment) {
      appointmentService.addAppointment(appointment);
   }

   @RequestMapping(method = RequestMethod.PUT, value = "/update")
   public void updateAppointment(@RequestBody Appointment appointment) {
      appointmentService.updateAppointment(appointment);
   }

   @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
   public void deleteAppointment(@PathVariable("id") long id) {
      appointmentService.deleteAppointment(id);
   }

   @RequestMapping(method = RequestMethod.GET, value = "/appointments/doctor/{id}")
   public List<Appointment> getAppointmentsByDoctorId(@PathVariable("id") long doctorId){

      return appointmentService.getAppointmentsByDoctorId(doctorId);
   }

   @RequestMapping(method = RequestMethod.GET, value = "/appointments/patient/{id}")
   public List<Appointment> getAppointmentsByPatientId(@PathVariable("id") long id){
      return appointmentService.getAppointmentsByPatientId(id);
   }

   // TODO: TEST!
   @RequestMapping(method = RequestMethod.GET, value = "/appointments/byDate")
   public List<Appointment> getAppointmentsByDateOfAppointment(@RequestBody Date date){
      return appointmentService.getAppointmentsByDateOfAppointment(date);
   }
}
