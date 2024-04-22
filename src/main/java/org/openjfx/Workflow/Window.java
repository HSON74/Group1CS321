package org.openjfx.Workflow;

import javafx.application.*;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;


public class Window extends Application {
    private Workflow WindowWorkflow;

    public static void main(String args[]) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Immigrant dependent System");
        Button b = new Button();
        b.setText("Register a Dependent");
        GridPane layout = new GridPane();
        Text title = new Text("Welcome to the Registrar! \nPlease click the button below to register a new dependent.");
        title.setFont(Font.font("seriff", FontWeight.NORMAL, FontPosture.ITALIC, 25));
        layout.add(title, 3, 0);
        layout.add(b, 3,50);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 960, 540);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        b.setOnAction(e -> {
            WindowWorkflow = new Workflow();
            WindowWorkflow.getDataEntry().dataEntryScene(WindowWorkflow.getDataEntry().systemForm,
                    WindowWorkflow,
                    primaryStage);
            primaryStage.setScene(WindowWorkflow.getDataEntry().dataEntryScene);
            WindowWorkflow.initSceneArray(scene);
        });
        primaryStage.show();

    }
}
