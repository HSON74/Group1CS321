package org.openjfx.Workflow;

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
        for (int i=0; i<label_names.length; i++){
            Label label = new Label(label_names[i]);
            TextField textField= new TextField ();
            textField.setPromptText(prompt+label_names[i] + " ex: " + format[i]);
                
                textField.setMaxWidth(300);
                
           //3 items per row
            if (i%3 ==0){
                col++;
                row = 0;
            }
            layout.add(label, row++, col);
            layout.add(textField, row++, col);
            
        }
        

        

        dataEntryScene = new Scene(layout, 960, 540);
        dataEntryScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(dataEntryScene);
        
        submit.setOnAction(e -> {
            DataEntryWorkflow.getReview().rDisplay(systemForm, DataEntryWorkflow, primaryStage);
            primaryStage.setScene(DataEntryWorkflow.getReview().rScene);
        });

       

    }

    public DataEntry(Workflow system) {
        this.systemInitiate = new Initiate(system);
    }

    public void startProcess() {
        systemForm = systemInitiate.convertToForm();
    }
    
}