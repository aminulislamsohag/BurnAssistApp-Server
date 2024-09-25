package com.springreact.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.model.PatientBurn;
import com.springreact.repository.PatientBurnRepository;

@Service
public class PatientBurnService {

	@Autowired
    private PatientBurnRepository patientBurnRepository;

    // Check if patient burn data exists
    public Optional<PatientBurn> findByPatientId(String patientId) {
        return Optional.ofNullable(patientBurnRepository.findByPatientId(patientId));
    }

    // Save patient burn data
    public PatientBurn savePatientBurnData(PatientBurn patientBurn) {
        return patientBurnRepository.save(patientBurn);
    }
	
}
