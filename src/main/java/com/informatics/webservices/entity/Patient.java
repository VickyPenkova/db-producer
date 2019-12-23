package com.informatics.webservices.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
   @Column(name = "name", nullable = false)
   private String name;
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "health_insurance_date", nullable = false)
   private Date healthInsuranceDate;
   @Column(name = "is_health_insured", nullable = false)
   private boolean isHealthInsured;
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "date_of_changed_gp", nullable = false)
   private Date dateOfChangedGp;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "doctor_id", nullable = false)
   private Doctor doctorGp;
   @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, //If we delete a patient it will be removed from everywhere
         fetch = FetchType.LAZY)
   private List<Appointment> appointments = new ArrayList<>();

   public Patient(String username, String password, String roles, String permissions, String name,
         Date healthInsuranceDate, boolean isHealthInsured, Date dateOfChangedGp, Doctor doctorGp,
         List<Appointment> appointments) {
      this.name = name;
      this.healthInsuranceDate = healthInsuranceDate;
      this.isHealthInsured = isHealthInsured;
      this.dateOfChangedGp = dateOfChangedGp;
      this.doctorGp = doctorGp;
      this.appointments = appointments;
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

   public Doctor getDoctorGp() {
      return doctorGp;
   }

   public void setDoctorGp(Doctor doctorGp) {
      this.doctorGp = doctorGp;
   }

}
