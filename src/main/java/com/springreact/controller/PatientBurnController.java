package com.springreact.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.model.PatientBurn;
import com.springreact.service.PatientBurnService;

@RestController
@RequestMapping("/api/patientBurn")
//@CrossOrigin("http://localhost:3000")
public class PatientBurnController {
	@Autowired
    private PatientBurnService patientBurnService;

    // Save burn data if no data exists
    @PostMapping("/save")
    public ResponseEntity<String> savePatientBurn(@RequestBody PatientBurn patientBurn) {
        // Check if burn data already exists for the given patient
        Optional<PatientBurn> existingBurn = patientBurnService.findByPatientId(patientBurn.getPatientId());
        
        if (existingBurn.isPresent()) {
            return ResponseEntity.status(409).body("Patient burn data already exists, no need to save again.");
        }

        // Save the burn data if it doesn't exist
        patientBurnService.savePatientBurnData(patientBurn);
        return ResponseEntity.ok("Patient burn data saved successfully.");
    }
	
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientBurn> getPatientBurnData(@PathVariable String patientId) {
        Optional<PatientBurn> burnData = patientBurnService.findByPatientId(patientId);

        // If burn data exists, return it, else return 404
        return burnData.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    
	

}
