package com.springreact.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springreact.model.PatientData;


public interface PatientDataRepository extends JpaRepository<PatientData, Long> {
	 List<PatientData> findByPatientId(String patientId); 
	 PatientData findFirstByPatientIdOrderByIdDesc(String patientId);
	 
}