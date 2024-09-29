package com.springreact.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.sourceforge.jFuzzyLogic.FIS;

import java.io.IOException;
import java.io.InputStream;


@Service
public class FuzzyLogicService {

	private FIS fis;

    public FuzzyLogicService() {
        try {
            // Load FCL file from classpath
            ClassPathResource resource = new ClassPathResource("fluid_resuscitation.fcl");
            InputStream inputStream = resource.getInputStream();
            fis = FIS.load(inputStream, true);

            if (fis == null) {
                System.err.println("Cannot load FCL file: " + resource.getPath());
                return;
            }
        } catch (IOException e) {
            System.err.println("Error loading FCL file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public double evaluate(double tbsa, double urineOutput) {
        // Set inputs
        fis.setVariable("tbsa", tbsa);
        fis.setVariable("urine_output", urineOutput);

        // Evaluate
        fis.evaluate();

        // Get output value
        return fis.getVariable("fluid_rate").getValue();
    }
	

}
