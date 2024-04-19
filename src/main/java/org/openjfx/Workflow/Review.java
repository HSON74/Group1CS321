package org.openjfx.Workflow;

import java.util.ArrayList;
import java.util.List;
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

/*
 * This is the review class of the application.
 */
public class Review {
    // The review scene
    protected Scene rScene;
    // The Form
    protected Form form;
    // Workflow reference
    protected Workflow reviewWorkflow;

    // The review display scene function
    public void rDisplay(Form form, Workflow system, Stage primaryStage) {
        this.reviewWorkflow = system;
        reviewdata(this.form, primaryStage);
        rScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(rScene);
    }

    // This function gets called when the user finishes reviewing the forms
    public void revalidate(Form form, Workflow system) {
        this.reviewWorkflow = system;
        this.form = reviewWorkflow.generateForm(form.getFields());
        // This checks if the form status is complete or not
        if (form.getFormStatus() != FormStatus.COMPLETE) {
            // If not, then the application will display an error message based on the
            // status
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Error Message:");
            Label label = new Label();
            // If the form is empty
            if (form.getFormStatus() == FormStatus.EMPTY) {
                label.setText("Error! Form is empty!");
                window.setMinWidth(250);
                window.setMinHeight(200);
            }
            // If the form is incomplete
            else if (form.getFormStatus() == FormStatus.INPROGRESS) {
                label.setText("Error! Some fields have not been fully filled out!");
                window.setMinWidth(400);
                window.setMinHeight(200);
            } else if (form.getFormStatus() == FormStatus.ERROR) {
                label.setText("Error! Data contains incorrect format!");
                window.setMinWidth(250);
                window.setMinHeight(200);
            }
            // This button returns the user to the data entry
            Button button = new Button("Ok");
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            reviewWorkflow.addScene(scene);
            window.setScene(scene);
            window.show();
            // The form gets returned to data entry
            button.setOnAction(e -> window.close());
        }
    }

    // This function reviews the form data
    public void reviewdata(Form file, Stage primaryStage) {
        // The immigrant and dependent orms are reviewed individually
        Immigrant immigrant = file.getImmigrant();
        Dependent dependent = file.getDependent();
        // This part is just setting up the display of the review screen
        GridPane grid = new GridPane();
        Text title = new Text("Form Review");
        title.setFont(Font.font("seirf", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text description = new Text("Please Review the Form Data of Immigrant and Dependent Before Revalidation");
        description.setFont(Font.font("seirf", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        Text immiName = new Text();
        if (immigrant.getMiddleName() == null)
            immiName.setText("Name: " + immigrant.getFirstName() + " " + immigrant.getLastName());
        else
            immiName.setText("Name: " + immigrant.getFirstName() + " " + immigrant.getMiddleName() + " "
                    + immigrant.getLastName());
        Text[] immigrantTexts = {
                new Text("Immigrant Form"),
                immiName,
                new Text("Age: " + immigrant.getAge()),
                new Text("Birthday: " + immigrant.getbirthMonth() + "/" + immigrant.getbirthDay() + "/"
                        + immigrant.getbirthYear()),
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
        if (dependent.getMiddleName() == null)
            depName.setText("Name: " + dependent.getFirstName() + " " + dependent.getLastName());
        else
            depName.setText("Name: " + dependent.getFirstName() + " " + dependent.getMiddleName() + " "
                    + dependent.getLastName());
        Text[] dependentTexts = {
                new Text("Dependent Form"),
                depName,
                new Text("Age: " + dependent.getAge()),
                new Text("Birthday: " + dependent.getbirthMonth() + "/" + dependent.getbirthDay() + "/"
                        + dependent.getbirthYear()),
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
            grid.add(immigrantTexts[i], 0, i + 2);
            dependentTexts[i].setFont(Font.font("seirf", FontWeight.NORMAL, FontPosture.REGULAR, 10));
            grid.add(dependentTexts[i], 1, i + 2);
        }
        grid.add(conf, 0, 15);
        // This button is for when the user finishes reviewing the form and wants to
        // submit for revalidation
        Button button = new Button("OK");
        button.setOnAction(e -> {
            // If the form is complete, then the form gets sent to the approval stage
            reviewWorkflow.getApproval().aDisplay(file, reviewWorkflow, primaryStage);
            primaryStage.setScene(reviewWorkflow.getApproval().approvalScene);
        });
        grid.add(button, 1, 17);
        // This button is for when the user wishes to go back to the data entry screen
        // to edit the form data
        Button back = new Button("Back");
        back.setOnAction(e -> {
            reviewWorkflow.returnForm(file);
            reviewWorkflow.getDataEntry().dataEntryScene(file, reviewWorkflow, primaryStage);
            primaryStage.setScene(reviewWorkflow.getDataEntry().dataEntryScene);
        });
        grid.add(back, 0, 17);
        Scene scene = new Scene(grid, 960, 540);
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
