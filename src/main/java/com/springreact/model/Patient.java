package com.springreact.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name="patientname", length = 255)
    private String patientname;
    
    @Column(name="patientid", length = 255)
    private String patientid;
    
    @Column(name = "admitdate")  
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date admitdate;
    
	public Patient() {
		}


	public Patient(Long id, String patientname, String patientid, Date admitdate) {
		this.id = id;
		this.patientname = patientname;
		this.patientid = patientid;
		this.admitdate = admitdate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPatientname() {
		return patientname;
	}


	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}


	public String getPatientid() {
		return patientid;
	}


	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}


	public Date getAdmitdate() {
		return admitdate;
	}


	public void setAdmitdate(Date admitdate) {
		this.admitdate = admitdate;
	}



}
