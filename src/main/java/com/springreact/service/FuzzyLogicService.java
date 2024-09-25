package com.springreact.service;

import org.springframework.stereotype.Service;
import net.sourceforge.jFuzzyLogic.FIS;

@Service
public class FuzzyLogicService {

	private FIS fis;

    public FuzzyLogicService() {
        // Load FCL file
        String fileName = "src/main/resources/fluid_resuscitation.fcl";
        fis = FIS.load(fileName, true);

        if (fis == null) {
            System.err.println("Cannot load file: " + fileName);
            return;
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
