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

    /* This function creates a new form during revalidation */
    public Form generateForm(List<TextField> fields) {
        // This count will count how many fields have been filled out
        int count = 0;
        int flag = 0;
        // The new form gets created
        Form newForm = new Form();
        Immigrant newImmigrant = new Immigrant();
        Dependent newDependent = new Dependent();
        newForm.setImmigrant(newImmigrant);
        newForm.setDependent(newDependent);
        // The form starts off as empty
        newForm.updateStatus(FormStatus.EMPTY);
        try {
            /*Immigrant info
            * get the immigrant associated with the form
            * set each member of the immigrant class by accessing the arraylist of created fields,
            * and iterating over the arraylist and at each field, retrieve the string text. If 
            * necessary parse the information into an Integer or Boolean so that it matches the 
            * arguments of the called method. 
            */
            // Every time a field has been filled out, the form will be marked in progress
            if (Helper.nullStringNull(fields.get(0).getText()) != null) {
                newForm.getImmigrant().setFirstName(fields.get(0).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(0);
            }
            if (Helper.nullStringNull(fields.get(1).getText()) != null) {
                newForm.getImmigrant().setMiddleName(fields.get(1).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(1);
            }
            if (Helper.nullStringNull(fields.get(2).getText()) != null) {
                newForm.getImmigrant().setLastName(fields.get(2).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(2);
            }
            if (Helper.nullStringNull(fields.get(3).getText()) != null) {
                if (Helper.checkAge(Integer.parseInt(fields.get(3).getText())) != 0) {
                    newForm.getImmigrant().setAge(Integer.parseInt(fields.get(3).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(3);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(4).getText()) != null) {
                if (Helper.intToMonth(Integer.parseInt(fields.get(4).getText())) != null) {
                    newForm.getImmigrant().setBirthMonth(Integer.parseInt(fields.get(4).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(4);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(6).getText()) != null) {
                newForm.getImmigrant().setBirthYear(Integer.parseInt(fields.get(6).getText()));
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(5);
            }
            if (Helper.nullStringNull(fields.get(5).getText()) != null) { 
                if (Helper.intToDay(newForm.getImmigrant().getbirthMonth(), Integer.parseInt(fields.get(5).getText()), newForm.getImmigrant().getbirthYear()) != null) {
                    newForm.getImmigrant().setBirthDay(Integer.parseInt(fields.get(5).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(6);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(7).getText()) != null) {
                if (Helper.ssNumberCheck(Integer.parseInt(fields.get(7).getText())) != 0) {
                    newForm.getImmigrant().setSSNumber(Integer.parseInt(fields.get(7).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(7);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(8).getText()) != null) {
                newForm.getImmigrant().setImmigrantPid(Integer.parseInt(fields.get(8).getText()));
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(8);
            }
            if (Helper.nullStringNull(fields.get(9).getText()) != null) {
                newForm.getImmigrant().setDependentPid(Integer.parseInt(fields.get(9).getText()));
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(9);
            }
            if (Helper.nullStringNull(fields.get(10).getText()) != null) {
                newForm.getImmigrant().setRace(fields.get(10).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(10);
            }
            if (Helper.nullStringNull(fields.get(11).getText()) != null) {
                newForm.getImmigrant().setGender(fields.get(11).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(11);
            }
            if (Helper.nullStringNull(fields.get(12).getText()) != null) {
                if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(12).getText())) != null) {
                    newForm.getImmigrant().setMarried(Boolean.parseBoolean(fields.get(12).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(12);
                }
            }
            if (Helper.nullStringNull(fields.get(13).getText()) != null) {
                newForm.getImmigrant().setPhoneNumber(fields.get(13).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(13);
            }
            if (Helper.nullStringNull(fields.get(14).getText()) != null) {
                newForm.getImmigrant().setFather(fields.get(14).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(14);
            }
            if (Helper.nullStringNull(fields.get(15).getText()) != null) {
                newForm.getImmigrant().setMother(fields.get(15).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(15);
            }
            if (Helper.nullStringNull(fields.get(16).getText()) != null) {
                newForm.getImmigrant().setAddress(fields.get(16).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(16);
            }
            if (Helper.nullStringNull(fields.get(17).getText()) != null) {
                if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(17).getText())) != null) {
                    newForm.getImmigrant().setemploymentStatus(Boolean.parseBoolean(fields.get(17).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(17);
                }
            }
            /*Dependent info
            * get the immigrant associated with the form
            * set each member of the immigrant class by accessing the arraylist of created fields,
            * and iterating over the arraylist and at each field, retrieve the string text. If 
            * necessary parse the information into an Integer or Boolean so that it matches the 
            * arguments of the called method. 
            */
            if (Helper.nullStringNull(fields.get(18).getText()) != null) {
                newForm.getDependent().setFirstName(fields.get(18).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(18);
            }
            if (Helper.nullStringNull(fields.get(19).getText()) != null) {
                newForm.getDependent().setMiddleName(fields.get(19).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(19);
            } 
            if (Helper.nullStringNull(fields.get(20).getText()) != null) {
                newForm.getDependent().setLastName(fields.get(20).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(20);
            }
            if (Helper.nullStringNull(fields.get(21).getText()) != null) {
                if (Helper.checkAge(Integer.parseInt(fields.get(21).getText())) != 0) {
                    newForm.getDependent().setAge(Integer.parseInt(fields.get(21).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(21);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(22).getText()) != null) {
                if (Helper.intToMonth(Integer.parseInt(fields.get(22).getText())) != null) {
                    newForm.getDependent().setBirthMonth(Integer.parseInt(fields.get(22).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(22);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(24).getText()) != null) {
                newForm.getDependent().setBirthYear(Integer.parseInt(fields.get(24).getText())); 
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(23);
            }
            if (Helper.nullStringNull(fields.get(23).getText()) != null) {
                if (Helper.intToDay(newForm.getImmigrant().getbirthMonth(), Integer.parseInt(fields.get(23).getText()), newForm.getImmigrant().getbirthYear()) != null) {
                    newForm.getDependent().setBirthDay(Integer.parseInt(fields.get(23).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(24);
                }
            }
            if (Helper.nullStringNull(fields.get(25).getText()) != null) {
                if (Helper.ssNumberCheck(Integer.parseInt(fields.get(25).getText())) != 0) {
                    newForm.getDependent().setSSNumber(Integer.parseInt(fields.get(25).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(25);
                }
                else flag = 1;
            }
            if (Helper.nullStringNull(fields.get(26).getText()) != null) {
                newForm.getDependent().setImmigrantPid(Integer.parseInt(fields.get(26).getText()));
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(26);
            }
            if (Helper.nullStringNull(fields.get(27).getText()) != null) {
                newForm.getDependent().setDependentPid(Integer.parseInt(fields.get(27).getText()));
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(27);
            }
            if (Helper.nullStringNull(fields.get(28).getText()) != null) {
                newForm.getDependent().setRace(fields.get(28).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(28);
            }
            if (Helper.nullStringNull(fields.get(29).getText()) != null) {
                newForm.getDependent().setGender(fields.get(29).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(29);
            }
            if (Helper.nullStringNull(fields.get(30).getText()) != null) {
                if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(30).getText())) != null) {
                    newForm.getDependent().setMarried(Boolean.parseBoolean(fields.get(30).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(30);
                }
            }
            if (Helper.nullStringNull(fields.get(31).getText()) != null) {
                newForm.getDependent().setPhoneNumber(fields.get(31).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(31);
            }
            if (Helper.nullStringNull(fields.get(32).getText()) != null) {
                newForm.getDependent().setFather(fields.get(32).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(32);
            }
            if (Helper.nullStringNull(fields.get(33).getText()) != null) {
                newForm.getDependent().setMother(fields.get(33).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(33);
            }
            if (Helper.nullStringNull(fields.get(34).getText()) != null) {
                newForm.getDependent().setAddress(fields.get(34).getText());
                count++;
                newForm.updateStatus(FormStatus.INPROGRESS);
                System.out.println(34);
            }
            if (Helper.nullStringNull(fields.get(35).getText()) != null) {
                if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(35).getText())) != null) {
                    newForm.getDependent().setemploymentStatus(Boolean.parseBoolean(fields.get(35).getText()));
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(35);
                }
            }
            if (Helper.nullStringNull(fields.get(36).getText()) != null) {
                if (Helper.BooleantoYN(Boolean.parseBoolean(fields.get(36).getText())) != null) {
                    newForm.getDependent().setPrevClaim(Boolean.parseBoolean(fields.get(36).getText())); 
                    count++;
                    newForm.updateStatus(FormStatus.INPROGRESS);
                    System.out.println(36);
                }
            }
            System.out.println(count);
            // If the error flag is marked, then the form has an error
            if (flag == 1) newForm.updateStatus(FormStatus.ERROR);
            // If there are no fields filled, then the form is still empty
            else if (count == 0) newForm.updateStatus(FormStatus.EMPTY);
            // Otherwise, if all fields are filled out, then the form is complete
            else if (count >= 37) newForm.updateStatus(FormStatus.COMPLETE);
        }
        // This is to check if NumberFormatException gets caught during execution
        catch (NumberFormatException e) {
            // This marks the form as an error
            newForm.updateStatus(FormStatus.ERROR);
        }
        // After that, the form gets returned
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