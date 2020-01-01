package com.informatics.webservices.service;

import com.informatics.webservices.entity.Doctor;
import com.informatics.webservices.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    private PasswordEncoder passwordEncoder;

    public DoctorService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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
        doctor.setPassword(this.passwordEncoder.encode(doctor.getPassword()));
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id:" + id));
        doctorRepository.delete(doctor);
    }

    public Doctor findDoctorByUsername(String username) {
        return doctorRepository.findDoctorByUsername(username);
    }

}
