package org.openjfx.Workflow;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openjfx.Business.Form;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DataEntry {
    public Initiate systemInitiate;
    public Form systemForm;
    protected Workflow DataEntryWorkflow;

    public Scene dataEntryScene;

    public void dataEntryScene(Form form, Workflow system, Stage primaryStage) {
        this.systemForm = form;
        this.DataEntryWorkflow = system;
        Button submit = new Button();
        submit.setText("Submit Data Entry Form");
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.add(submit, 20, 20);
        
        String [] label_names = {"First Name: ", "Middle Name: ", "Last Name: ", "Age: ", "Birth Month: ",
             "Birth Day: ", "Birth Year: ","SS Number: ", "Immigrant PID: ", "Dependent PID: ", "Race: ",
            "Gender: ", "Married: ", "Phone Number: ", "Father's Name: ", "Mother's Name: ",
            "Address: ", "Employment Status: "};
        String [] format = {"John", "Carlton", "Doe", "25", "06", "03",
            "1999", "222880000", "1893", "5833", "Caucasion", "Male",
            "True", "8889563400", "Jason Doe", "Katherine Doe", 
            "4400 University Dr, Fairfax, VA 22030", "True" };
        String prompt = "Enter ";
        
        int col =0;
        int row = 0;
        ArrayList<TextField> fields = new ArrayList<>();
        for (int j =0; j<2; j++){
            String person = "Immigrant ";
            if (j == 1){
                person = "Dependent ";
            }
        for (int i=0; i<label_names.length; i++){

            Label label = new Label(person + label_names[i]);
            TextField textField= new TextField ();
            textField.setPromptText(prompt+label_names[i] + " ex: " + format[i]);
            //textField.setMaxWidth(300);
            fields.add(textField);
           //3 items per row
            if (i%3 ==0){
                col++;
                row = 0;
            }
            layout.add(label, row++, col);
            layout.add(textField, row++, col);
            if ((j ==1) && ((i== label_names.length -1))){
                Label label2 = new Label(person + "Previously Claimed: ");
                TextField textField2= new TextField ();
                textField2.setPromptText("Previously Claimed: " + " ex: " + "True");
                //textField2.setMaxWidth(300);
                fields.add(textField2);
                
                layout.add(label2, 0, ++col);
                layout.add(textField2, 1, col);
            }
            
        }
    }


        dataEntryScene = new Scene(layout, 1170, 700);
        dataEntryScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(dataEntryScene);
        //systemForm.setDependent(systemForm.getImmigrant().getDependent());
        
        submit.setOnAction(e -> {
            for (int i = 0; i<fields.size(); i++){
                switch (i){
                    /*Immigrant info */
                    case 0: systemForm.getImmigrant().setFirstName(fields.get(i).getText()); break;
                    case 1: systemForm.getImmigrant().setMiddleName(fields.get(i).getText()); break;
                    case 2: systemForm.getImmigrant().setLastName(fields.get(i).getText()); break;
                    case 3: systemForm.getImmigrant().setAge(Integer.parseInt(fields.get(i).getText()));break;
                    case 4: systemForm.getImmigrant().setBirthMonth(Integer.parseInt(fields.get(i).getText())); break;
                    case 5: systemForm.getImmigrant().setBirthDay(Integer.parseInt(fields.get(i).getText())); break;
                    case 6: systemForm.getImmigrant().setBirthYear(Integer.parseInt(fields.get(i).getText())); break;
                    case 7: systemForm.getImmigrant().setSSNumber(Integer.parseInt(fields.get(i).getText())); break;
                    case 8: systemForm.getImmigrant().setImmigrantPid(Integer.parseInt(fields.get(i).getText())); break;
                    case 9: systemForm.getImmigrant().setDependentPid(Integer.parseInt(fields.get(i).getText())); break;
                    case 10: systemForm.getImmigrant().setRace(fields.get(i).getText()); break;
                    case 11: systemForm.getImmigrant().setGender(fields.get(i).getText()); break;
                    case 12: systemForm.getImmigrant().setMarried(Boolean.parseBoolean(fields.get(i).getText())); break;
                    case 13: systemForm.getImmigrant().setPhoneNumber(fields.get(i).getText()); break;
                    case 14: systemForm.getImmigrant().setFather(fields.get(i).getText()); break;
                    case 15: systemForm.getImmigrant().setMother(fields.get(i).getText()); break;
                    case 16: systemForm.getImmigrant().setemploymentStatus(Boolean.parseBoolean(fields.get(i).getText())); break;
                    
                   // Dependent info 
                    case 17: systemForm.getDependent().setFirstName(fields.get(i).getText()); break;
                    case 18: systemForm.getDependent().setMiddleName(fields.get(i).getText()); break;
                    case 19: systemForm.getDependent().setLastName(fields.get(i).getText()); break;
                    case 20: systemForm.getDependent().setAge(Integer.parseInt(fields.get(i).getText()));break;
                    case 21: systemForm.getDependent().setBirthMonth(Integer.parseInt(fields.get(i).getText())); break;
                    case 22: systemForm.getDependent().setBirthDay(Integer.parseInt(fields.get(i).getText())); break;
                    case 23: systemForm.getDependent().setBirthYear(Integer.parseInt(fields.get(i).getText())); break;
                    case 24: systemForm.getDependent().setSSNumber(Integer.parseInt(fields.get(i).getText())); break;
                    case 25: systemForm.getDependent().setImmigrantPid(Integer.parseInt(fields.get(i).getText())); break;
                    case 26: systemForm.getDependent().setDependentPid(Integer.parseInt(fields.get(i).getText())); break;
                    case 27: systemForm.getDependent().setRace(fields.get(i).getText()); break;
                    case 28: systemForm.getDependent().setGender(fields.get(i).getText()); break;
                    case 29: systemForm.getDependent().setMarried(Boolean.parseBoolean(fields.get(i).getText())); break;
                    case 30: systemForm.getDependent().setPhoneNumber(fields.get(i).getText()); break;
                    case 31: systemForm.getDependent().setFather(fields.get(i).getText()); break;
                    case 32: systemForm.getDependent().setMother(fields.get(i).getText()); break;
                    case 33: systemForm.getDependent().setemploymentStatus(Boolean.parseBoolean(fields.get(i).getText())); break;
                    case 34: systemForm.getDependent().setPrevClaim(Boolean.parseBoolean(fields.get(i).getText())); break;
                    
                }}
            DataEntryWorkflow.getReview().rDisplay(systemForm, DataEntryWorkflow, primaryStage);
            primaryStage.setScene(DataEntryWorkflow.getReview().rScene);
        });

        primaryStage.show();
    }
    

    public DataEntry(Workflow system) {
        this.systemInitiate = new Initiate(system);

    }

    public void startProcess() {
        systemForm = systemInitiate.convertToForm();
    }
    
}