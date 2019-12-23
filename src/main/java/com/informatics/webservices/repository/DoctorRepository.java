package com.informatics.webservices.repository;

import java.util.List;

import com.informatics.webservices.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findDoctorByUsername(String username);
}
