package com.informatics.webservices.repository;

import com.informatics.webservices.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findDoctorByUsername(String username);
}
