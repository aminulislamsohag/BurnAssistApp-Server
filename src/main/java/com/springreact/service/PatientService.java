package com.springreact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.model.Patient;
import com.springreact.repository.PatientRepository;



@Service
public class PatientService {

	@Autowired
    private PatientRepository patientRepository;

	//show all patient list
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    //add new patient
    public Patient addPatient(Patient newpatient) {
        return patientRepository.save(newpatient);
    }
    
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
    
    public List<Patient> searchPatients(String query) {
        return patientRepository.findByPatientnameContainingOrPatientidContaining(query, query);
    }
    
    
    
    
		
}
