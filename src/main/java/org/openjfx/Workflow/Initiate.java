package org.openjfx.Workflow;

import org.openjfx.Business.Form;

public class Initiate {
    private String nextStep;
    protected Workflow system;

    public Initiate(Workflow system) {
        this.system = system;
    }

    public Form convertToForm() {
        return system.generateForm();
    }

    public boolean registerPerson(Form form) {
        // Workflow for review and approval
        return system.submit(form);
    }

    /* Setter and Getter for Initiate Class */
    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getNextString() {
        return nextStep;
    }

}
