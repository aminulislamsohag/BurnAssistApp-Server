package com.springreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springreact.model.PatientBurn;

public interface PatientBurnRepository extends JpaRepository<PatientBurn, Long> {
	PatientBurn findByPatientId(String patientId);
}
