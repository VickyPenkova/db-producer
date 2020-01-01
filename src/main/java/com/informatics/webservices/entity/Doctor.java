package com.informatics.webservices.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Table(name = "doctors", schema = "DoctorAppointments")
@Entity
public class Doctor extends Audit implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "username", nullable = false)
   private String username; // will retrieve the DB for user with such EGN as Id
   @Column(name = "name", nullable = false)
   private String name; // User's full name
   @Column(name = "doctor_password", nullable = false)
   private String password;
   @Column(name = "speciality", nullable = false)
   private String medicalSpeciality;
   @Column(name = "is_gp", nullable = false)
   private boolean isGp;
   @Column(name = "roles", nullable = false)
   private String roles;

   @Column(name = "permissions")
   private String permissions = "";

   @OneToMany(mappedBy = "doctorGp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<Patient> patients = new ArrayList<>();

   @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<Appointment> appointments = new ArrayList<>();

   private int active = 1;

   public Doctor() {
   }

   public Doctor(String name, String username, String password, String medicalSpeciality, boolean isGp, String roles,
         int active) {
      this.username = username;
      this.password = password;
      this.name = name;
      this.medicalSpeciality = medicalSpeciality;
      this.isGp = isGp;
      this.roles = roles;
      this.active = active;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String egn) {
      this.username = egn;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getMedicalSpeciality() {
      return medicalSpeciality;
   }

   public void setMedicalSpeciality(String medicalSpeciality) {
      this.medicalSpeciality = medicalSpeciality;
   }

   public boolean isGp() {
      return isGp;
   }

   public void setGp(boolean gp) {
      isGp = gp;
   }

   public int getActive() {
      return active;
   }

   public String getRoles() {
      return roles;
   }

   public void setRoles(String role) {
      this.roles = role;
   }

   @JsonManagedReference
   public List<Patient> getPatients() {
      return patients;
   }

   public void setPatients(List<Patient> patients) {
      this.patients = patients;
   }

   @JsonManagedReference(value = "doctor-appointment")
   public List<Appointment> getAppointments() {
      return appointments;
   }

   public void setAppointments(List<Appointment> appointments) {
      this.appointments = appointments;
   }

   public List<String> getRoleList() {
      if (this.roles.length() > 0) {
         return Arrays.asList(this.roles.split(","));
      }
      return new ArrayList<>();
   }

   public List<String> getPermissionList() {
      if (this.permissions.length() > 0) {
         return Arrays.asList(this.permissions.split(","));
      }
      return new ArrayList<>();
   }
}
