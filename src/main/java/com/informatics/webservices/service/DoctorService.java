package com.informatics.webservices.service;

import java.util.ArrayList;
import java.util.List;

import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getDoctors() {
        List<Doctor> doctorsList = new ArrayList<>();
        doctorRepository.findAll().forEach(course -> doctorsList.add(course));

        return doctorsList;
    }

    public Doctor getDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        return doctor;
    }

    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void updateDoctor(long id, Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        doctorRepository.delete(doctor);
    }

    public List<Doctor> findDoctorByUsername(String username) {
        List<Doctor> doctorsList = new ArrayList<>();
        doctorRepository.findDoctorByUsername(username).forEach(course -> doctorsList.add(course));
        return doctorsList;
    }

}
