package edu.ung.jrcrav8591.CompanyProject.controller;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.sql.*;
import java.util.Objects;


import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import edu.ung.jrcrav8591.CompanyProject.model.Company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.print.DocFlavor;


public class CompanyController {


    @FXML
    private TextField company_name_text, company_address_text, company_address2_text, company_city_text,
        company_state_text, company_zip_text;
    private Label company_name_label;


    public void createCompanyBtn(ActionEvent event) throws Exception {

        String newCompanyName = company_name_text.getText();
        String newCompanyAddress = company_address_text.getText();
        String newCompanyAddress2 = company_address2_text.getText();
        String newCompanyCity = company_city_text.getText();
        String newCompanyState = company_state_text.getText();
        String newCompanyZip = company_zip_text.getText();

        Company newCompany = new Company(newCompanyName, newCompanyAddress, newCompanyAddress2, newCompanyCity, newCompanyState, newCompanyZip);

        Connection connection;
        try {
            String query = "INSERT INTO Company VALUES(?, ?, ?, ?, ?, ?)";

            connection = SQLiteConnector.connect();
            PreparedStatement statement;
            if (connection != null) {
                statement = connection.prepareStatement(query);
                statement.setString(1, newCompany.getName());
                statement.setString(2, newCompany.getAddress());
                statement.setString(3, newCompany.getAddress2());
                statement.setString(4, newCompany.getCity());
                statement.setString(5, newCompany.getState());
                statement.setString(6, newCompany.getZip());
                statement.executeUpdate();
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company_name_label = new Label();
        company_name_label.setText("poop");

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_company_info.fxml").toURL();

        Parent root = FXMLLoader.load(url);
        window.setTitle("Company Info");
        window.setScene(new Scene(root, 600, 400));
    }

}
