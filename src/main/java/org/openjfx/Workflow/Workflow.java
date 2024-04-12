package org.openjfx.Workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.lang.Math;

import org.openjfx.Business.*;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


    public Form generateForm(List<TextField> fields) {
        // This flag will be marked false if there's something wrong with the data
        boolean flag = true;
        Form newForm = new Form();
        Immigrant newImmigrant = new Immigrant();
        Dependent newDependent = new Dependent();
        newForm.setImmigrant(newImmigrant);
        newForm.setDependent(newDependent);
        for (int i = 0; i<fields.size(); i++){ //iterate over arrayList of textfields
            try {
                switch (i) {
                    /*Immigrant info
                    * get the immigrant associated with the form
                    * set each member of the immigrant class by accessing the arraylist of created fields,
                    *      and iterating over the arraylist and at each field, retrieve the string text. If 
                    *      necessary parse the information into an Integer or Boolean so that it matches the 
                    *      arguments of the called method. 
                    */
                    case 0: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setFirstName(fields.get(i).getText()); 
                        break;
                    case 1:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) newForm.getImmigrant().setMiddleName("");
                        else newForm.getImmigrant().setMiddleName(fields.get(i).getText()); 
                        break;
                    case 2: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setLastName(fields.get(i).getText()); 
                        break;
                    case 3: 
                        if (Helper.checkAge(Integer.parseInt(fields.get(i).getText())) == 0) flag = false;
                        else newForm.getImmigrant().setAge(Integer.parseInt(fields.get(i).getText()));
                        break;
                    case 4: 
                        if (Helper.intToMonth(Integer.parseInt(fields.get(i).getText())) == null) flag = false;
                        else newForm.getImmigrant().setBirthMonth(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 5: 
                        if (Helper.intToYear(Integer.parseInt(fields.get(i+1).getText())) == null) flag = false;
                        else newForm.getImmigrant().setBirthYear(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 6: 
                        if (Helper.intToDay(newForm.getImmigrant().getbirthMonth(), Integer.parseInt(fields.get(i-1).getText()), newForm.getImmigrant().getbirthYear()) == null) {
                            flag = false;
                        }
                        else newForm.getImmigrant().setBirthDay(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 7: 
                        if (Helper.ssNumberCheck(Integer.parseInt(fields.get(i).getText())) == 0) flag = false;
                        else newForm.getImmigrant().setSSNumber(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 8: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setImmigrantPid(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 9: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setDependentPid(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 10: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setRace(fields.get(i).getText()); 
                        break;
                    case 11: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setGender(fields.get(i).getText()); 
                        break;
                    case 12: 
                        if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(i).getText())) == null) flag = false;
                        else newForm.getImmigrant().setMarried(Boolean.parseBoolean(fields.get(i).getText())); 
                        break;
                    case 13: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setPhoneNumber(fields.get(i).getText());
                        break;
                    case 14: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setFather(fields.get(i).getText());
                        break;
                    case 15:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setMother(fields.get(i).getText());
                        break;
                    case 16: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getImmigrant().setAddress(fields.get(i).getText());
                        break;
                    case 17: 
                        if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(i).getText())) == null) flag = false;
                        else newForm.getImmigrant().setemploymentStatus(Boolean.parseBoolean(fields.get(i).getText())); 
                        break;
                /*Dependent info
                    * get the immigrant associated with the form
                    * set each member of the immigrant class by accessing the arraylist of created fields,
                    *      and iterating over the arraylist and at each field, retrieve the string text. If 
                    *      necessary parse the information into an Integer or Boolean so that it matches the 
                    *      arguments of the called method. 
                    */
                    case 18: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setFirstName(fields.get(i).getText()); 
                        break;
                    case 19: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) newForm.getImmigrant().setMiddleName("");
                        else newForm.getDependent().setMiddleName(fields.get(i).getText()); 
                        break;
                    case 20:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setLastName(fields.get(i).getText()); 
                        break;
                    case 21: 
                        if (Helper.checkAge(Integer.parseInt(fields.get(i).getText())) == 0) flag = false;
                        else newForm.getDependent().setAge(Integer.parseInt(fields.get(i).getText()));
                        break;
                    case 22:
                        if (Helper.intToMonth(Integer.parseInt(fields.get(i).getText())) == null) flag = false;
                        else newForm.getDependent().setBirthMonth(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 23:
                        if (Helper.intToYear(Integer.parseInt(fields.get(i+1).getText())) == null) flag = false;
                        else newForm.getDependent().setBirthYear(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 24:
                        if (Helper.intToDay(newForm.getImmigrant().getbirthMonth(), Integer.parseInt(fields.get(i-1).getText()), newForm.getImmigrant().getbirthYear()) == null) {
                            flag = false;
                        }
                        else newForm.getDependent().setBirthDay(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 25:
                        if (Helper.ssNumberCheck(Integer.parseInt(fields.get(i).getText())) == 0) flag = false;
                        else newForm.getDependent().setSSNumber(Integer.parseInt(fields.get(i).getText())); 
                        break;
                    case 26: newForm.getDependent().setImmigrantPid(newForm.getImmigrant().getImmigrantPid()); break;
                    case 27: newForm.getDependent().setDependentPid(newForm.getImmigrant().getDependentPid()); break;
                    case 28:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setRace(fields.get(i).getText()); 
                        break;
                    case 29:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setGender(fields.get(i).getText()); 
                        break;
                    case 30:
                        if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(i).getText())) == null) flag = false;
                        else newForm.getDependent().setMarried(Boolean.parseBoolean(fields.get(i).getText())); 
                        break;
                    case 31: 
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setPhoneNumber(fields.get(i).getText());
                        break;
                    case 32:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setFather(fields.get(i).getText());
                        break;
                    case 33:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setMother(fields.get(i).getText());
                        break;
                    case 34:
                        if (Helper.nullStringNull(fields.get(i).getText()) == null) flag = false;
                        else newForm.getDependent().setAddress(fields.get(i).getText());
                        break;
                    case 35:
                        if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(i).getText())) == null) flag = false;
                        else newForm.getDependent().setemploymentStatus(Boolean.parseBoolean(fields.get(i).getText())); 
                        break;
                    case 36: 
                        if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(i).getText())) == null) flag = false;
                        else newForm.getDependent().setPrevClaim(Boolean.parseBoolean(fields.get(i).getText())); 
                        newForm.updateStatus(FormStatus.COMPLETE); 
                        break; // the form should be complete if gotten this far
                }
            }
            catch (NumberFormatException e) {
                flag = false;
                newForm.updateStatus(FormStatus.ERROR);
            }
            if (flag = false) break;
        }
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