package org.openjfx.Workflow;

import org.openjfx.Business.Form;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Email {

    public static void display(String email, Form form, Stage myStage) {
        myStage.setTitle("Email Confimation");
        Scene emailScene;
        GridPane emailPane = new GridPane();
        Text tempText = new Text("The form is send to this email:" + email + "\n");
        emailPane.add(tempText, 1, 1);
        emailScene = new Scene(emailPane);
        myStage.setScene(emailScene);

    }
}
