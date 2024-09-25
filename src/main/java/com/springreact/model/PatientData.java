package com.springreact.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patientdata")
public class PatientData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column(name="patientid", length = 255)
    private String patientId;
    
    @Column(name = "totalburn", scale = 2)
    private double tbsa;
    
    @Column(name = "urineoutput",  scale = 2)
    private double huo;
    
    @Column(name = "fulidrate",  scale = 2)
    private double ifr;
    
    @Column(name = "stage", columnDefinition = "TIMESTAMP") // Ensure it's stored as a timestamp
    private LocalDateTime stage; // Change int to LocalDateTime

	public PatientData() {

	}

	public PatientData(Long id, String patientId, double tbsa, double huo, double ifr, LocalDateTime stage) {
		this.id = id;
		this.patientId = patientId;
		this.tbsa = tbsa;
		this.huo = huo;
		this.ifr = ifr;
		this.stage = stage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public double getTbsa() {
		return tbsa;
	}

	public void setTbsa(double tbsa) {
		this.tbsa = tbsa;
	}

	public double getHuo() {
		return huo;
	}

	public void setHuo(double huo) {
		this.huo = huo;
	}

	public double getIfr() {
		return ifr;
	}

	public void setIfr(double ifr) {
		this.ifr = ifr;
	}

	public LocalDateTime  getStage() {
		return stage;
	}

	public void setStage(LocalDateTime  stage) {
		this.stage = stage;
	} 
    
	
    
    
    
	
	
}
