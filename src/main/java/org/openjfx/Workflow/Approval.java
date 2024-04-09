package org.openjfx.Workflow;

import org.openjfx.Business.Form;
import org.openjfx.Business.FormStatus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

public class Approval {
    protected enum ApprovalStatus {
        INPROGRESS, NEEDREVIEW, COMPLETE
    }

    private Form approvalForm; // The store instance of the form pass in to the application
    private Database database; //
    private ApprovalStatus approvalStatus; //
    private Workflow approvalWorkflow; // The Approval workflow that is currently run on.
    @SuppressWarnings("unused")
    private boolean isAdd; //

    // Application Scene update
    public Scene approvalScene;
    public Scene emailScene;
    public Scene approvalCompleteScene;
    public Scene rejectScene;

    /* Set the the application scene when the user sumbit the form for approval */
    public void Adisplay(Form form, Workflow system, Stage primaryStage) {
        if (form == null) {
            System.out.println("Null form");
            return;
        }
        if (system == null) {
            System.out.println("Null system");
            return;
        }
        this.approvalForm = form;
        this.approvalWorkflow = system;
        //
        Text[] approvalTextsI = { new Text("First Name: "), new Text("Middle Name:"),
                new Text("Last Name:"),
                new Text("Age: "), new Text("Birth Month:"), new Text("Birth Day:"), new Text("Birth Year: "),
                new Text("Address: "), new Text("Social Secrutiy Numbers:"), new Text("Race: "), new Text("Gender: "),
                new Text("Married Status: "), new Text("Phone Numbers: "), new Text("Father Name: "),
                new Text("Mother Name: "), new Text("Employment Status: "), new Text("Immigrant PID: "),
                new Text("Immirgrant's Dependent PID: ") };
        Text[] approvalTextsD = { new Text("First Name: "), new Text("Middle Name:"),
                new Text("Last Name:"),
                new Text("Age: "), new Text("Birth Month:"), new Text("Birth Day:"), new Text("Birth Year: "),
                new Text("Address: "), new Text("Social Secrutiy Numbers:"), new Text("Race: "), new Text("Gender: "),
                new Text("Married Status: "), new Text("Phone Numbers: "), new Text("Father Name: "),
                new Text("Mother Name: "), new Text("Employment Status: "), new Text("Pre-Claim: "),
                new Text("Dependent PID: "), };
        Text stringForm = new Text("Resigter for Dependent for Immigrant");
        Text stringFormDescription = new Text(
                "The form is currently in the approval.\n Make sure to all field are fill before sumbmision\n"
                        + "We will check and get you a Dependent if the Dependent is field is not add.\n"
                        + "we wil not Dependent is not \n"
                        + "If you are a Dependent with Immigrant not fill out.\n"
                        + "We wil add to you to the system and assign an immirgrant when avaiable\n");
        Text stringImmigrant = new Text("Immigrant Resigter:");
        Text stringDependent = new Text("Dependent Resigter:");
        stringForm.setFont(Font.font("seirf", FontWeight.BOLD, FontPosture.REGULAR,
                50));
        stringFormDescription.setFont(Font.font("seirf", FontWeight.NORMAL,
                FontPosture.REGULAR, 15));
        stringImmigrant.setFont(Font.font("seirf", FontWeight.BOLD,
                FontPosture.REGULAR, 25));
        stringDependent.setFont(Font.font("seirf", FontWeight.BOLD,
                FontPosture.REGULAR, 25));
        String[] formI = new String[approvalTextsI.length];
        String[] formD = new String[approvalTextsD.length];
        String status = "";
        if (checkFrom(status)) {
            System.out.println("Form exist");
            int i = 0;
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getFirstName());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getMiddleName());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getLastName());
            formI[i++] = String.valueOf(form.getImmigrant().getAge());
            formI[i++] = Helper.nullStringCheck(Helper.intToMonth(form.getImmigrant().getbirthMonth()));
            formI[i++] = Helper.intToDay(form.getImmigrant().getbirthMonth(), form.getImmigrant().getbirthDay(),
                    form.getImmigrant().getbirthYear());
            formI[i++] = Helper.intToYear(form.getImmigrant().getbirthYear());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getAddress());
            formI[i++] = String.valueOf(form.getImmigrant().getSSNumber());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getRace());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getGender());
            formI[i++] = Helper.BooleantoYN(form.getImmigrant().getMarriedStatus());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getPhoneNumber());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getFatherName());
            formI[i++] = Helper.nullStringCheck(form.getImmigrant().getMotherName());
            formI[i++] = Helper.BooleantoYN(form.getImmigrant().getemploymentStatus());
            formI[i++] = String.valueOf(form.getImmigrant().getImmigrantPid());
            formI[i++] = String.valueOf(form.getImmigrant().getDependentPid());
            i = 0;
            formD[i++] = Helper.nullStringCheck(form.getDependent().getFirstName());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getMiddleName());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getLastName());
            formD[i++] = String.valueOf(form.getDependent().getAge());
            formD[i++] = Helper.nullStringCheck(Helper.intToMonth(form.getDependent().getbirthMonth()));
            formD[i++] = Helper.intToDay(form.getDependent().getbirthMonth(), form.getDependent().getbirthDay(),
                    form.getDependent().getbirthYear());
            formD[i++] = Helper.intToYear(form.getDependent().getbirthYear());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getAddress());
            formD[i++] = String.valueOf(form.getDependent().getSSNumber());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getRace());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getGender());
            formD[i++] = Helper.BooleantoYN(form.getDependent().getMarriedStatus());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getPhoneNumber());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getFatherName());
            formD[i++] = Helper.nullStringCheck(form.getDependent().getMotherName());
            formD[i++] = Helper.BooleantoYN(form.getDependent().getemploymentStatus());
            formD[i++] = Helper.BooleantoYN(form.getDependent().getPrevClaim());
            formD[i++] = String.valueOf(form.getDependent().getDependentPid());
        } else {
            int i = 0;
            formI[i++] = "My First Name";
            formI[i++] = "My Middle Name";
            formI[i++] = "My Last Name";
            formI[i++] = "25";
            formI[i++] = "April";
            formI[i++] = "23";
            formI[i++] = "1972";
            formI[i++] = "1234 Address";
            formI[i++] = "Number";
            formI[i++] = "Race";
            formI[i++] = "Gender";
            formI[i++] = "No";
            formI[i++] = "Give me a call";
            formI[i++] = "My Father";
            formI[i++] = "My Mother";
            formI[i++] = "Yes";
            formI[i++] = "5000";
            formI[i++] = "6000";
            i = 0;
            formD[i++] = "My Dependent First Name";
            formD[i++] = "My Dependent Middle Name";
            formD[i++] = "My Dependent Last Name";
            formD[i++] = "My Dependent age is 1";
            formD[i++] = "April";
            formD[i++] = "21";
            formD[i++] = "2025";
            formD[i++] = "My Dependent Address";
            formD[i++] = "My Dependent Number";
            formD[i++] = "My Dependent Race";
            formD[i++] = "My Dependent Gender";
            formD[i++] = "No";
            formD[i++] = "My Dependent Phone number";
            formD[i++] = "My Dependent Father Name";
            formD[i++] = "My Dependent Mother Name";
            formD[i++] = "No";
            formD[i++] = "Yes";
            formD[i++] = "6000";
        }
        // Scene pane setup
        GridPane approvalGridPane = new GridPane();
        approvalGridPane.setAlignment(Pos.CENTER);
        approvalGridPane.setHgap(10);
        approvalGridPane.setVgap(10);
        approvalGridPane.setPadding(new Insets(10, 10, 10, 10));
        approvalGridPane.setMinSize(960, 540);
        approvalGridPane.setMaxSize(1920, 1080);
        approvalGridPane.setAlignment(Pos.CENTER);
        approvalGridPane.add(stringForm, 1, 0, 25, 1);
        approvalGridPane.add(stringFormDescription, 15, 1, 25, 1);
        approvalGridPane.add(stringImmigrant, 0, 2);
        approvalGridPane.add(stringDependent, 24, 2);
        approvalGridPane.setAlignment(Pos.CENTER_LEFT);
        for (int i = 0; i < approvalTextsI.length; i++) {
            approvalGridPane.add(approvalTextsI[i], 0, i + 5);
            approvalGridPane.add(new Text(formI[i]), 1, i + 5);

        }
        for (int i = 0; i < approvalTextsD.length; i++) {
            approvalGridPane.add(approvalTextsD[i], 24, i + 5);
            approvalGridPane.add(new Text(formD[i]), 25, i + 5);
        }

        // Button Setup
        Button sumbitButton = new Button();
        Button rejectButton = new Button();
        sumbitButton.setScaleX(3);
        sumbitButton.setScaleY(3);
        sumbitButton.setText("Approval Form");
        sumbitButton.setTextFill(Color.BLACK);
        rejectButton.setText("   Reject Form   ");
        rejectButton.setTextFill(Color.BLACK);
        rejectButton.setScaleX(3);
        rejectButton.setScaleY(3);
        approvalGridPane.add(sumbitButton, 28, 5, 3, 3);
        approvalGridPane.add(rejectButton, 28, 9, 3, 3);

        sumbitButton.setOnAction(
                e -> {
                    if (!this.isAdd && checkFrom(status)) {
                        this.isAdd = connection();
                        Stage minStage = new Stage();
                        minStage.setTitle("Result of Form");
                        GridPane tempGridPane = new GridPane();
                        TextArea myTextArea = new TextArea("Contragulation, you complete the form");
                        myTextArea.setWrapText(true);
                        tempGridPane.add(myTextArea, 1, 1);
                        approvalGridPane.setScaleShape(false);
                        approvalCompleteScene = new Scene(tempGridPane, 250, 250);
                        minStage.setScene(approvalCompleteScene);
                        minStage.showAndWait();
                    } else if (isAdd) {
                        Stage minStage = new Stage();
                        minStage.setTitle("Result of Form");
                        GridPane tempGridPane = new GridPane();
                        approvalCompleteScene = new Scene(tempGridPane, 250, 250);
                        minStage.setScene(approvalCompleteScene);
                        minStage.showAndWait();
                    }
                });
        rejectButton.setOnAction(e -> {
            if (isAdd) {
                setDatabase(null, form);
                database.removeDependent(form.getImmigrant().getImmigrantPid());
                database.removeDependent(form.getDependent().getDependentPid());
                isAdd = false;
            } else {
                approvalWorkflow.getReview().rDisplay(this.getForm(), this.getWorkflow(), primaryStage);
                primaryStage.setScene(approvalWorkflow.getReview().rScene);
            }
        });

        // Scene set to application window
        approvalScene = new Scene(approvalGridPane, 1920, 1080);
        approvalScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(approvalScene);
        approvalWorkflow.addScene(approvalScene);
        primaryStage.setMaximized(true);

    }

    // Approval Class construct that will be call in the workflow.
    public Approval(String dataBase, Form form) {
        this.isAdd = false;
        this.approvalForm = form;
        setApprovalStatus(ApprovalStatus.INPROGRESS);
        setDatabase(dataBase, form);

    }

    /* A method for check form is the form is null */
    private boolean checkFrom(String status) {
        if (approvalForm == null) {
            System.err.println("The form is null");
            return false;
        }
        if (approvalForm.getImmigrant() == null && approvalForm.getDependent() == null) {
            System.err.println("The immigrant or dependent form ");
            return false;
        }
        String informationForCheck = "";
        if (fullCheck(informationForCheck)) {
            int iPid = approvalForm.getImmigrant().getImmigrantPid();
            int dPid = approvalForm.getDependent().getDependentPid();
            database.checkData(iPid, dPid, status);
            return true;
        } else {
            GridPane myReject = new GridPane();
            return false;
        }
    }

    /*
     * A method that will coonection, add, or
     * update based on the if the infromation is
     * in the system record.
     */
    public boolean connection() {
        String status = "";
        if (checkFrom(status)) {
            setApprovalStatus(ApprovalStatus.COMPLETE);
            return database.addData(approvalForm);
        } else {
            return false;
        }
    }

    /**
     * This method will full check the form one later te
     * 
     * @return boolean if the all importent information correctly enter
     */
    private boolean fullCheck(String missing) {
        missing = "";
        if (approvalForm == null) {
            missing = "Form is null";
            return false;
        }
        if (approvalForm.getFormStatus() != FormStatus.COMPLETE) {
            missing = "Form is not complete";
            return false;
        }
        if (approvalForm.getImmigrant() == null && approvalForm.getDependent() == null) {
            missing = "Form is don't have Immigrant and Dependent information.";
            return false;
        }
        if (approvalForm.getImmigrant() != null) {
            if (approvalForm.getImmigrant().getFirstName() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: First Name";
                } else {
                    missing = "Immigrant Field: First Name";
                }
            } else if (approvalForm.getImmigrant().getLastName() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Last Name";
                } else {
                    missing = ", Last Name";
                }
            } else if (approvalForm.getImmigrant().getAge() <= 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Age";
                } else {
                    missing = ", Age";
                }
            } else if (approvalForm.getImmigrant().getAddress() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Address";
                } else {
                    missing = ", Address";
                }
            } else if (approvalForm.getImmigrant().getSSNumber() < 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Social Security Number";
                } else {
                    missing = ", Social Security Number";
                }
            } else if (approvalForm.getImmigrant().getRace() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Race";
                } else {
                    missing = ", Race";
                }
            } else if (approvalForm.getImmigrant().getGender() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Gender";
                } else {
                    missing = ", Gender";
                }
            } else if (approvalForm.getImmigrant().getPhoneNumber() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Phone Number";
                } else {
                    missing = ", Phone Number";
                }
            } else if (approvalForm.getImmigrant().getImmigrantPid() <= 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Immigrant PID";
                } else {
                    missing = ", Immigrant PID";
                }
            } else if (approvalForm.getImmigrant().getDependentPid() <= 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Immigrant Field: Dependent PID";
                } else {
                    missing = ", Dependent PID";
                }
            }
        }
        if (approvalForm.getDependent() != null) {
            if (!missing.equalsIgnoreCase("")) {
                missing = "; and ";
            }
            if (approvalForm.getDependent().getFirstName() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: First Name";
                } else {
                    missing = "Dependent Field: First Name";
                }
            } else if (approvalForm.getDependent().getLastName() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Last Name";
                } else {
                    missing = ", Last Name";
                }
            } else if (approvalForm.getDependent().getAge() <= 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Age";
                } else {
                    missing = ", Age";
                }
            } else if (approvalForm.getDependent().getAddress() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Address";
                } else {
                    missing = ", Address";
                }
            } else if (approvalForm.getDependent().getSSNumber() < 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Social Security Number";
                } else {
                    missing = ", Social Security Number";
                }
            } else if (approvalForm.getDependent().getRace() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Race";
                } else {
                    missing = ", Race";
                }
            } else if (approvalForm.getDependent().getGender() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Gender";
                } else {
                    missing = ", Gender";
                }
            } else if (approvalForm.getDependent().getPhoneNumber() == null) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Phone Number";
                } else {
                    missing = ", Phone Number";
                }
            } else if (approvalForm.getDependent().getDependentPid() <= 0) {
                if (missing.equalsIgnoreCase("")) {
                    missing = "Dependent Field: Dependent PID";
                } else {
                    missing = ", Dependent PID";
                }
            }
        }
        return missing.equalsIgnoreCase("");
    }

    /* Setter and Getter for Approval Class */
    public void setForm(Form form) {
        if (form == null)
            return;
        if (form.getImmigrant() == null || form.getDependent() == null) {
            System.err.println("file is missing");
            return;
        }
        this.approvalForm = form;
    }

    public Form getForm() {
        return approvalForm;
    }

    protected void setDatabase(String dataBase, Form form) {
        System.out.println("System connect to database");
        this.database = new Database(form, dataBase, null);
    }

    protected Database getDatabase() {
        return database;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus status) {
        this.approvalStatus = status;
    }

    public Workflow getWorkflow() {
        return approvalWorkflow;
    }

    public Scene getApprovalScene() {
        return approvalScene;
    }
}
