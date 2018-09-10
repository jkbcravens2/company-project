package edu.ung.jrcrav8591.CompanyProject.model;

import edu.ung.jrcrav8591.CompanyProject.controller.CompanyInfoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CompanyInfo extends Application {

    @Override
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/layout_company_info.fxml"));
        window.setTitle("Hello World");
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }
}
