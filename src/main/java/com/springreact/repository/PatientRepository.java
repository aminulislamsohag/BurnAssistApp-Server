package com.springreact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springreact.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	//for search patients
	List<Patient> findByPatientnameContainingOrPatientidContaining(String patientname, String patientid);

}
