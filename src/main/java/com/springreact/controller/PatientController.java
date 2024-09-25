package com.springreact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.model.Patient;
import com.springreact.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class PatientController {

	 @Autowired
	    private PatientService patientService;

	 //show all patient data from database
	    @GetMapping("/patients")
	    public List<Patient> getAllPatients() {
	        return patientService.getAllPatients();	 // return list data
	    }

	 //new patient save  
	   // function is a controller method 
	    @PostMapping("/addpatient")
	    public ResponseEntity<Patient> addPatient(@RequestBody Patient newpatient) {
	        Patient savedPatient = patientService.addPatient(newpatient);
	        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED); 	//httpstatus.created means return status code 201
	    }
	    
	    @DeleteMapping("/deletepatient/{id}")
	    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
	        try {
	            patientService.deletePatientById(id);
	            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error deleting patient", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    
	    @GetMapping("/search")
	    public List<Patient> searchPatients(@RequestParam("query") String query) {
	        return patientService.searchPatients(query);
	    }
	
	
}
