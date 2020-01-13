package com.informatics.webservices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients", schema = "DoctorAppointments")
public class Patient extends Audit implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "username", nullable = false)
   private String username; // will retrieve the DB for user with such EGN as Id
   @Column(name = "patient_password", nullable = false)
   private String password;
   @Column(name = "name", nullable = false)
   private String name;
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "health_insurance_date", nullable = false)
   private Date healthInsuranceDate;
   @Column(name = "is_health_insured", nullable = false)
   private boolean isHealthInsured;
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "date_of_changed_gp")
   private Date dateOfChangedGp;

   @ManyToOne
   @JoinColumn(name = "doctor_id",referencedColumnName = "id", nullable = false)
   private Doctor doctorGp;
   @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
   private List<Appointment> appointments = new ArrayList<>();

   @Column(name = "roles", nullable = false)
   private String roles = "";

   @Column(name="permissions")
   private String permissions = "";

   private int active = 1;

   public Patient(){}

   public Patient(String username, String password, String roles, String name,
                  Date healthInsuranceDate, boolean isHealthInsured, Doctor doctorGp, int active) {
      this.username = username;
      this.password = password;
      this.name = name;
      this.healthInsuranceDate = healthInsuranceDate;
      this.isHealthInsured = isHealthInsured;
      this.dateOfChangedGp = this.getCreatedAt();
      this.doctorGp = doctorGp;
      this.roles = roles;
      this.active=active;
   }
   public Patient(String username, String password, String roles, String name,
                  Date healthInsuranceDate, Date dateOfChangedGp,boolean isHealthInsured, Doctor doctorGp, int active) {
      this.username = username;
      this.password = password;
      this.name = name;
      this.healthInsuranceDate = healthInsuranceDate;
      this.isHealthInsured = isHealthInsured;
      this.dateOfChangedGp = dateOfChangedGp;
      this.doctorGp = doctorGp;
      this.roles = roles;
      this.active=active;
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

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public boolean isHealthInsured() {
      return isHealthInsured;
   }

   public void setHealthInsured(boolean healthInsured) {
      isHealthInsured = healthInsured;
   }

   public Date getHealthInsuranceDate() {
      return healthInsuranceDate;
   }

   public void setHealthInsuranceDate(Date healthInsuranceDate) {
      this.healthInsuranceDate = healthInsuranceDate;
   }

   public void setHealthInsurred(boolean healthInsured) {
      isHealthInsured = healthInsured;
   }

   public Date getDateOfChangedGp() {
      return dateOfChangedGp;
   }

   public void setDateOfChangedGp(Date dateOfChangedGp) {
      this.dateOfChangedGp = dateOfChangedGp;
   }

   @JsonBackReference
   public Doctor getDoctorGp() {
      return doctorGp;
   }

   public void setDoctorGp(Doctor doctorGp) {
      this.doctorGp = doctorGp;
   }

   @JsonManagedReference(value = "patient-appointment")
   public List<Appointment> getAppointments() {
      return appointments;
   }

   public void setAppointments(List<Appointment> appointments) {
      this.appointments = appointments;
   }

   public String getRoles() {
      return this.roles;
   }

   public void setRoles(String roles) {
      this.roles = roles;
   }

   public int getActive() {
      return active;
   }

   public void setActive(int active) {
      this.active = active;
   }

   public List<String> getRoleList(){
      if(this.roles.length() > 0){
         return Arrays.asList(this.roles.split(","));
      }
      return new ArrayList<>();
   }

   public List<String> getPermissionList(){
      if(this.permissions.length() > 0){
         return Arrays.asList(this.permissions.split(","));
      }
      return new ArrayList<>();
   }
}