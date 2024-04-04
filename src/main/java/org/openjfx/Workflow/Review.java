package org.openjfx.Workflow;

import org.openjfx.Business.Immigrant;
import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.FormStatus;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

public class Review {
    protected Scene rScene;
    protected Workflow reviewWorkflow;
    protected Form reviewForm;

    public void rDisplay(Form form, Workflow system, Stage primaryStage) {
        this.reviewForm = form;
        this.reviewWorkflow = system;
        reviewdata(form, primaryStage);
        rScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(rScene);
    }

    public void revalidate(Form file, Stage primaryStage) {
        if (file.getFormStatus() != FormStatus.COMPLETE) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Error Message:");
            Label label = new Label();
            if (file.getFormStatus() == FormStatus.EMPTY) {
                label.setText("Error! Form is empty!");
                window.setMinWidth(250);
                window.setMinHeight(200);
            }
            else if (file.getFormStatus() == FormStatus.INPROGRESS) {
                label.setText("Error! Some fields have not been fully filled out!");
                window.setMinWidth(400);
                window.setMinHeight(200);
            } 
            Button button = new Button("Return to Data Entry");
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            reviewWorkflow.addScene(scene);
            window.setScene(scene);
            window.show();
            button.setOnAction(e->{
                reviewWorkflow.returnForm(file);
                reviewWorkflow.getDataEntry().dataEntryScene(file, reviewWorkflow, primaryStage);
                primaryStage.setScene(reviewWorkflow.getDataEntry().dataEntryScene);
                window.close();
            });
        } else {
            reviewWorkflow.submit(file);
            reviewWorkflow.getApproval().Adisplay(file, reviewWorkflow, primaryStage);
            primaryStage.setScene(reviewWorkflow.getApproval().approvalScene);
        }
    }

    public void reviewdata(Form file, Stage primaryStage) {
        file.updateStatus(FormStatus.COMPLETE);
        Immigrant immigrant = file.getImmigrant();
        Dependent dependent = file.getDependent();
        GridPane grid = new GridPane();
        Text title = new Text("Form Review");
        title.setFont(Font.font("seirf", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text description = new Text("Please Review the Form Data of Immigrant and Dependent Before Revalidation");
        description.setFont(Font.font("seirf", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        Text immiName = new Text();
        if (immigrant.getMiddleName() == null) immiName.setText("Name: " + immigrant.getFirstName() + " " + immigrant.getLastName());
        else immiName.setText("Name: " + immigrant.getFirstName() + " " + immigrant.getMiddleName() + " " + immigrant.getLastName());
        Text[] immigrantTexts = {
            new Text("Immigrant Form"),
            immiName, 
            new Text("Age: " + immigrant.getAge()), 
            new Text("Birthday: " + immigrant.getbirthMonth() + "/" + immigrant.getbirthDay() + "/" + immigrant.getbirthYear()),
            new Text("Address: " + immigrant.getAddress()),
            new Text("Social Security Number: " + immigrant.getSSNumber()), 
            new Text("Race: " + immigrant.getRace()), 
            new Text("Gender: " + immigrant.getGender()), 
            new Text("Marriage Status: " + immigrant.getMarriedStatus()),
            new Text("Phone Number: " + immigrant.getPhoneNumber()), 
            new Text("Father: " + immigrant.getFatherName()), 
            new Text("Mother: " + immigrant.getMotherName()),
            new Text("Occupation: " + immigrant.getemploymentStatus())
        };
        // Dependent Name
        Text depName = new Text();
        if (dependent.getMiddleName() == null) depName.setText("Name: " + dependent.getFirstName() + " " + dependent.getLastName());
        else depName.setText("Name: " + dependent.getFirstName() + " " + dependent.getMiddleName() + " " + dependent.getLastName());
        Text[] dependentTexts = {
            new Text("Dependent Form"),
            depName, 
            new Text("Age: " + dependent.getAge()), 
            new Text("Birthday: " + dependent.getbirthMonth() + "/" + dependent.getbirthDay() + "/" + dependent.getbirthYear()),
            new Text("Address: " + dependent.getAddress()),
            new Text("Social Security Number: " + dependent.getSSNumber()), 
            new Text("Race: " + dependent.getRace()), 
            new Text("Gender: " + dependent.getGender()), 
            new Text("Marriage Status: " + dependent.getMarriedStatus()),
            new Text("Phone Number: " + dependent.getPhoneNumber()), 
            new Text("Father: " + dependent.getFatherName()), 
            new Text("Mother: " + dependent.getMotherName()),
            new Text("Occupation: " + dependent.getemploymentStatus())
        };
        Text conf = new Text("Press Submit to submit the form if everything is correct");
        conf.setFont(Font.font("seirf", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(960, 540);
        grid.setMaxSize(1920, 1080);
        grid.add(title, 0, 0);
        grid.add(description, 0, 1);
        immigrantTexts[0].setFont(Font.font("seirf", FontWeight.BOLD, FontPosture.REGULAR, 15));
        grid.add(immigrantTexts[0], 0, 2);
        dependentTexts[0].setFont(Font.font("seirf", FontWeight.BOLD, FontPosture.REGULAR, 15));
        grid.add(dependentTexts[0], 1, 2);
        for (int i = 1; i < immigrantTexts.length; i++) {
            immigrantTexts[i].setFont(Font.font("seirf", FontWeight.NORMAL, FontPosture.REGULAR, 10));
            grid.add(immigrantTexts[i],0,i+2);
            dependentTexts[i].setFont(Font.font("seirf", FontWeight.NORMAL, FontPosture.REGULAR, 10));
            grid.add(dependentTexts[i],1,i+2);
        }
        grid.add(conf, 0, 15);
        Button button = new Button("OK");
        button.setOnAction(e -> revalidate(file, primaryStage));
        grid.add(button, 0, 17);
        Scene scene = new Scene(grid, 960,540);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        setScene(scene);
        reviewWorkflow.addScene(scene);
    }

    /*
     * Setter and Getter for Review class.
     */
    public void setScene(Scene scene) {
        this.rScene = scene;
    }

    public Scene getScene() {
        return rScene;
    }
}
