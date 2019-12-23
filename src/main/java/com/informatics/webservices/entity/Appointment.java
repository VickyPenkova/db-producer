package com.informatics.webservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Table(name = "appointments", schema = "DoctorAppointments")
@Entity
public class Appointment extends Audit implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "date_of_appointment", nullable = false)
   private Date dateOfAppointment;

   @Column(name = "diagnosis", nullable = false)
   private String diagnosis;

   @Column(name = "medication")
   private String medication;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "sick_leave_start_date", nullable = false)
   private Date sickLeaveStartDate;

   @Column(name = "sick_leave_days", nullable = false)
   private int sickLeaveDays;

   @ManyToOne
   @JoinColumn(name = "fk_doctor", nullable = false)
   private Doctor doctor;

   @ManyToOne
   @JoinColumn(name = "fk_patient", nullable = false)
   private Patient patient;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getDateOfAppointment() {
      return dateOfAppointment;
   }

   public void setDateOfAppointment(Date dateOfAppointment) {
      this.dateOfAppointment = dateOfAppointment;
   }

   public String getDiagnosis() {
      return diagnosis;
   }

   public void setDiagnosis(String diagnosis) {
      this.diagnosis = diagnosis;
   }

   public String getMedication() {
      return medication;
   }

   public void setMedication(String medication) {
      this.medication = medication;
   }

   public Date getSickLeaveStartDate() {
      return sickLeaveStartDate;
   }

   public void setSickLeaveStartDate(Date sickLeaveStartDate) {
      this.sickLeaveStartDate = sickLeaveStartDate;
   }

   public int getSickLeaveDays() {
      return sickLeaveDays;
   }

   public void setSickLeaveDays(int sickLeaveDays) {
      this.sickLeaveDays = sickLeaveDays;
   }

   public Doctor getDoctor() {
      return doctor;
   }

   public void setDoctor(Doctor doctor) {
      this.doctor = doctor;
   }

   public Patient getPatient() {
      return patient;
   }

   public void setPatient(Patient patient) {
      this.patient = patient;
   }
}

