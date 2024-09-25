package com.springreact.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient_burn")
public class PatientBurn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column(name="patientid", length = 255)
    private String patientId;
    
    @Column(name = "head", scale = 2)
    private double head;
    
    @Column(name = "frontbody", scale = 2)
    private double frontBody;
    
    @Column(name = "backbody", scale = 2)
    private double backBody;
    
    @Column(name = "leftleg", scale = 2)
    private double leftLeg;
    
    @Column(name = "rightleg", scale = 2)
    private double rightLeg;
    
    @Column(name = "lefthand", scale = 2)
    private double leftHand;
    
    @Column(name = "righthand", scale = 2)
    private double rightHand;

	public PatientBurn() {

	}

	public PatientBurn(Long id, String patientId, double head, double frontBody, double backBody, double leftLeg,
			double rightLeg, double leftHand, double rightHand) {

		this.id = id;
		this.patientId = patientId;
		this.head = head;
		this.frontBody = frontBody;
		this.backBody = backBody;
		this.leftLeg = leftLeg;
		this.rightLeg = rightLeg;
		this.leftHand = leftHand;
		this.rightHand = rightHand;
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

	public double getHead() {
		return head;
	}

	public void setHead(double head) {
		this.head = head;
	}

	public double getFrontBody() {
		return frontBody;
	}

	public void setFrontBody(double frontBody) {
		this.frontBody = frontBody;
	}

	public double getBackBody() {
		return backBody;
	}

	public void setBackBody(double backBody) {
		this.backBody = backBody;
	}

	public double getLeftLeg() {
		return leftLeg;
	}

	public void setLeftLeg(double leftLeg) {
		this.leftLeg = leftLeg;
	}

	public double getRightLeg() {
		return rightLeg;
	}

	public void setRightLeg(double rightLeg) {
		this.rightLeg = rightLeg;
	}

	public double getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(double leftHand) {
		this.leftHand = leftHand;
	}

	public double getRightHand() {
		return rightHand;
	}

	public void setRightHand(double rightHand) {
		this.rightHand = rightHand;
	}
	
	
	
	
	
	
	
}
