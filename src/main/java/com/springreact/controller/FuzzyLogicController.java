package com.springreact.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.model.PatientData;
import com.springreact.repository.PatientDataRepository;



@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000")
public class FuzzyLogicController {
	//@Autowired
   // private FuzzyLogicService fuzzyLogicService;

    @Autowired
    private PatientDataRepository patientDataRepository;



    @PostMapping("/savePatientData")
    public void savePatientData( @RequestBody PatientData patientData) {
    	
    	 // Automatically set only the current date and time (no garbage values)
        LocalDateTime currentTime = LocalDateTime.now();
        
        // You can format this further if needed, but LocalDateTime should suffice
        patientData.setStage(currentTime);
        // Save the patient data (TBSA, HUO, IFR, etc.) to the database
        patientDataRepository.save(patientData);
    }
    
    @GetMapping("/history/{patientId}")
    public List<PatientData> getHistoryByPatientId(@PathVariable String patientId) {
        return patientDataRepository.findByPatientId(patientId);
    }
    
    @GetMapping("/patient/{patientid}/totalBurnInput")
    public double getTotalBurn(@PathVariable String patientid) {
        PatientData patientData = patientDataRepository.findFirstByPatientIdOrderByIdDesc(patientid);
        if (patientData != null) {
            return patientData.getTbsa();
        } else {
            // Return 0 or a default value if no data found
            return 0.0;
        }
    }
}
