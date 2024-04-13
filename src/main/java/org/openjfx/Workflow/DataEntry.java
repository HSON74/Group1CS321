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

        ArrayList<TextField> fields = new ArrayList<>(); 
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
            
           
        systemForm.updateStatus(FormStatus.COMPLETE);
        systemForm.setFields(fields);
        DataEntryWorkflow.getReview().revalidate(form, system);
        DataEntryWorkflow.getReview().rDisplay(form, system, primaryStage);//hand the form off to the review stage
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