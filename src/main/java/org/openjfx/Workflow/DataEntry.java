package org.openjfx.Workflow;

import java.util.ArrayList;

import org.openjfx.Business.Form;
import org.openjfx.Business.FormStatus;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class DataEntry {
    public Initiate systemInitiate;
    public Form systemForm;
    protected Workflow DataEntryWorkflow;

    public Scene dataEntryScene;

    public void dataEntryScene(Form form, Workflow system, Stage primaryStage) {
        //initialize form and the workflow
        this.systemForm = form;
        this.DataEntryWorkflow = system;

        Button submit = new Button(); //submit button
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
        
        //col and row to set the position to place the nodes on the gridpane
        int col =0;
        int row = 0;

        //arraylist of textfields to keep track of later

        ArrayList<TextField> fields = systemForm.getFields(); 
        for (int j =0; j<2; j++){ // the first iteration will be for the immigrant and second iteration will be for dependent
            String person = "Immigrant ";
            if (j == 1){ //second iteration
                person = "Dependent ";
            }
        for (int i=0; i<label_names.length; i++){ //match the label names with textFields

            Label label = new Label(person + label_names[i]);
            TextField textField= new TextField ();
            textField.setPromptText(prompt+label_names[i] + " ex: " + format[i]);//set the prompt for the textfield as a guide to the user
            
           //3 items per row
            if (i%3 ==0){
                col++;
                row = 0;
            }
            layout.add(label, row++, col);
            layout.add(textField, row++, col);
            fields.add(textField); //add the textfield to the arrayList of textfields
            if ((j ==1) && ((i== label_names.length-1))){ //if on the last iteration and for dependent, add previously claimed
                Label label2 = new Label(person + "Previously Claimed: ");
                TextField textField2= new TextField ();
                textField2.setPromptText("Previously Claimed: " + " ex: " + "True");
                fields.add(textField2);
                layout.add(label2, 0, ++col);
                layout.add(textField2, 1, col);
            }
            
        }
        
    }
        dataEntryScene = new Scene(layout, 1170, 700);
        dataEntryScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(dataEntryScene);
        
        /*On pressing the submit button do this .... */
        submit.setOnAction(e -> {
            
            // systemForm.updateStatus(FormStatus.INPROGRESS); //form in progress but not complete
            // for (int i = 0; i<fields.size(); i++){ //iterate over arrayList of textfields
            //     switch (i){
            //         /*Immigrant info
            //          * get the immigrant associated with the form
            //          * set each member of the immigrant class by accessing the arraylist of created fields,
            //          *      and iterating over the arraylist and at each field, retrieve the string text. If 
            //          *      necessary parse the information into an Integer or Boolean so that it matches the 
            //          *      arguments of the called method. 
            //          */
            //         case 0: systemForm.getImmigrant().setFirstName(fields.get(i).getText()); break;
            //         case 1: systemForm.getImmigrant().setMiddleName(fields.get(i).getText()); break;
            //         case 2: systemForm.getImmigrant().setLastName(fields.get(i).getText()); break;
            //         case 3: systemForm.getImmigrant().setAge(Integer.parseInt(fields.get(i).getText()));break;
            //         case 4: systemForm.getImmigrant().setBirthMonth(Integer.parseInt(fields.get(i).getText())); break;
            //         case 5: systemForm.getImmigrant().setBirthDay(Integer.parseInt(fields.get(i).getText())); break;
            //         case 6: systemForm.getImmigrant().setBirthYear(Integer.parseInt(fields.get(i).getText())); break;
            //         case 7: systemForm.getImmigrant().setSSNumber(Integer.parseInt(fields.get(i).getText())); break;
            //         case 8: systemForm.getImmigrant().setImmigrantPid(Integer.parseInt(fields.get(i).getText())); break;
            //         case 9: systemForm.getImmigrant().setDependentPid(Integer.parseInt(fields.get(i).getText())); break;
            //         case 10: systemForm.getImmigrant().setRace(fields.get(i).getText()); break;
            //         case 11: systemForm.getImmigrant().setGender(fields.get(i).getText()); break;
            //         case 12: systemForm.getImmigrant().setMarried(Boolean.parseBoolean(fields.get(i).getText())); break;
            //         case 13: systemForm.getImmigrant().setPhoneNumber(fields.get(i).getText()); break;
            //         case 14: systemForm.getImmigrant().setFather(fields.get(i).getText()); break;
            //         case 15: systemForm.getImmigrant().setMother(fields.get(i).getText()); break;
            //         case 16: systemForm.getImmigrant().setAddress(fields.get(i).getText());
            //         case 17: systemForm.getImmigrant().setemploymentStatus(Boolean.parseBoolean(fields.get(i).getText())); break;
                    
            //         /*Dependent info
            //          * get the immigrant associated with the form
            //          * set each member of the immigrant class by accessing the arraylist of created fields,
            //          *      and iterating over the arraylist and at each field, retrieve the string text. If 
            //          *      necessary parse the information into an Integer or Boolean so that it matches the 
            //          *      arguments of the called method. 
            //          */
            //         case 18: systemForm.getDependent().setFirstName(fields.get(i).getText()); break;
            //         case 19: systemForm.getDependent().setMiddleName(fields.get(i).getText()); break;
            //         case 20: systemForm.getDependent().setLastName(fields.get(i).getText()); break;
            //         case 21: systemForm.getDependent().setAge(Integer.parseInt(fields.get(i).getText()));break;
            //         case 22: systemForm.getDependent().setBirthMonth(Integer.parseInt(fields.get(i).getText())); break;
            //         case 23: systemForm.getDependent().setBirthDay(Integer.parseInt(fields.get(i).getText())); break;
            //         case 24: systemForm.getDependent().setBirthYear(Integer.parseInt(fields.get(i).getText())); break;
            //         case 25: systemForm.getDependent().setSSNumber(Integer.parseInt(fields.get(i).getText())); break;
            //         case 26: systemForm.getDependent().setImmigrantPid(Integer.parseInt(fields.get(i).getText())); break;
            //         case 27: systemForm.getDependent().setDependentPid(Integer.parseInt(fields.get(i).getText())); break;
            //         case 28: systemForm.getDependent().setRace(fields.get(i).getText()); break;
            //         case 29: systemForm.getDependent().setGender(fields.get(i).getText()); break;
            //         case 30: systemForm.getDependent().setMarried(Boolean.parseBoolean(fields.get(i).getText())); break;
            //         case 31: systemForm.getDependent().setPhoneNumber(fields.get(i).getText()); break;
            //         case 32: systemForm.getDependent().setFather(fields.get(i).getText()); break;
            //         case 33: systemForm.getDependent().setMother(fields.get(i).getText()); break;
            //         case 34: systemForm.getDependent().setAddress(fields.get(i).getText()); break;
            //         case 35: systemForm.getDependent().setemploymentStatus(Boolean.parseBoolean(fields.get(i).getText())); break;
            //         case 36: systemForm.getDependent().setPrevClaim(Boolean.parseBoolean(fields.get(i).getText())); 
            //         systemForm.updateStatus(FormStatus.COMPLETE);break; // the form should be complete if gotten this far
                    
            //     }}
        systemForm.updateStatus(FormStatus.COMPLETE);
        //DataEntryWorkflow.getReview().revalidate(systemForm, primaryStage);//hand the form off to the review stage
        primaryStage.setScene(DataEntryWorkflow.getReview().rScene);
        DataEntryWorkflow.getReview().revalidate(systemForm, primaryStage);
        DataEntryWorkflow.getReview().rDisplay(systemForm, DataEntryWorkflow, primaryStage);//(systemForm, primaryStage);
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