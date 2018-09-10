package edu.ung.jrcrav8591.CompanyProject;

import edu.ung.jrcrav8591.CompanyProject.controller.CompanyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/layout_main.fxml"));
        window.setTitle("Create New Company");
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }
}

