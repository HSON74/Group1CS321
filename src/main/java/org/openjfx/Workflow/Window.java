package org.openjfx.Workflow;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
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
        b.setText("Start a new Form");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);
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
