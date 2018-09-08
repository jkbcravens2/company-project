package edu.ung.jrcrav8591.CompanyProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/layout_main.fxml"));
        window.setTitle("Create New Company");
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

