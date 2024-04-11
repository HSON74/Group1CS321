package org.openjfx.Workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.openjfx.Business.*;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Workflow {
    private Integer wfid;
    private String step;
    private Integer objid;
    protected Review workflowReview;
    protected Approval workflowApproval;
    protected DataEntry workflowDataEntry;
    protected Database workflowDatabase;
    protected List<Scene> sceneArray;
    protected HashMap<Integer, String> wfItems;

    // This is the workflow constructor if there's already a form
    public Workflow(Form form) {
        workflowDataEntry = new DataEntry(this);
        workflowReview = new Review();
        workflowApproval = new Approval(null, form);
        wfItems = new HashMap<>();
    }

    // This constructor is for when a new form is being created at the start of the
    // class
    public Workflow() {
        workflowDataEntry = new DataEntry(this);
        workflowDataEntry.startProcess();
        workflowReview = new Review();
        workflowApproval = new Approval(null, workflowDataEntry.systemForm);
        wfItems = new HashMap<>();
    }

    public void initSceneArray(Scene titleScene) {
        sceneArray = new ArrayList<>();
        sceneArray.add(titleScene);
    }

    public Scene getScene(int index) {
        return sceneArray.get(index);
    }

    public void addScene(Scene scene) {
        sceneArray.add(scene);
    }

    public void removeScene(Scene scene) {
        sceneArray.remove(scene);
    }

    // This method is for when a new workflow item is being added
    public Boolean addWFItem(String step, Integer onjid) {
        if (wfItems.get(onjid) != null) {
            return false;
        } 
        else {
            wfItems.put(onjid, step);
            setStep(step);
            setObjid(onjid);
            return true;
        }
    }

    public String getNextWFItem(Integer onjid) {
        return wfItems.get(onjid);
    }

    public Integer countWFItems() {
        return wfItems.size();
    }

    public Form returnForm(Form form) {
        return form;
    }

    public boolean submit(Form form) {
        return workflowDatabase.addData(form);
    }


    public Form generateForm() {
        Form newForm = new Form();
        Immigrant newImmigrant = new Immigrant();
        Dependent newDependent = new Dependent();
        newForm.setImmigrant(newImmigrant);
        newForm.setDependent(newDependent);
        return newForm;
    }

    /*
     * Setter and Getter for Workflow Class.
     */
    public Integer getWfid() {
        return wfid;
    }

    public void setWfid(Integer wfid) {
        this.wfid = wfid;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public Review getReview() {
        return workflowReview;
    }

    public Approval getApproval() {
        return workflowApproval;
    }

    public DataEntry getDataEntry() {
        return workflowDataEntry;
    }
}