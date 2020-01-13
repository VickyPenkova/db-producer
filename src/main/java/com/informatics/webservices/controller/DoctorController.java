package com.informatics.webservices.controller;

import com.informatics.webservices.entity.Appointment;
import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.entity.Patient;
import com.informatics.webservices.service.AppointmentService;
import com.informatics.webservices.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

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

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{username}")
    public void deleteDoctorByUsername(@PathVariable("username") String username) {
        doctorService.deleteDoctor(username);
    }


    @RequestMapping("/username/{username}")
    public Doctor getDoctorsByUserName(@PathVariable("username") String username) {
        return doctorService.findDoctorByUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/patients")
    public List<Patient> getPatientsByDoctorId(@PathVariable long id){
        return this.doctorService.getDoctor(id).getPatients();
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/updateGP/{username}/{newDocID}")
    public void updateGP(@PathVariable("username") String username,@PathVariable("newDocID") String newDocID){

        this.doctorService.updateGP(username,newDocID);
    }

    @RequestMapping(method = RequestMethod.GET, value="/findByAppointment/{id}")
    public Doctor getDoctorByAppointments(@PathVariable long id){
        Appointment app = appointmentService.getAppointment(id);
        return doctorService.getDoctorByAppointments(app);

    }

}
