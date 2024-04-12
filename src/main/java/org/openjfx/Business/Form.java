package org.openjfx.Business;
import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Form {
    private Immigrant immigrantForm;
    private Dependent dependentForm;
    private String lastEdit;
    private FormStatus formStatus;
    private ArrayList<TextField> fields;

    public Form() {
        formStatus = FormStatus.EMPTY;
    }

    public void inputInfo() {

    }

    public void updateStatus(FormStatus status) {
        this.formStatus = status;
    }
    public ArrayList<TextField> getFields(){
        return this.fields;
    }
    public void setFields(ArrayList<TextField> fields){
        this.fields = fields;
    }
    /*
     * Setter and Getter for the Form Class
     */
    public void setlastEdit(String lastEdit) {
        this.lastEdit = lastEdit;
    }

    public String getlastEdit() {
        return lastEdit;
    }

    public FormStatus getFormStatus() {
        return formStatus;
    }

    public void setImmigrant(Immigrant immigrantForm) {
        this.immigrantForm = immigrantForm;
    }

    public void setDependent(Dependent dependentForm) {
        this.dependentForm = dependentForm;
    }

    public Immigrant getImmigrant() {
        return immigrantForm;
    }

    public Dependent getDependent() {
        return dependentForm;
    }
}
