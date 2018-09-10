package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompanyInfoController {

    @FXML
    private Label company_name_label, company_address_label, company_city_label, company_zip_label, company_state_label;

    @FXML
    private void initialize() {
        Connection connection;
        try {
            String companyNameQuery = "SELECT NAME, Address, City, State, Zip FROM Company LIMIT 1;";

            String companyName = "", companyAddress = "", companyCity = "", companyState = "", companyZip = "";

            connection = SQLiteConnector.connect();
            Statement statement;
            if (connection != null) {
                statement = connection.createStatement();
                ResultSet result = statement.executeQuery(companyNameQuery);
                while (result.next()) {
                    companyName = result.getString("name");
                    companyAddress = result.getString("address");
                    companyCity = result.getString("city");
                    companyState = result.getString("state");
                    companyZip = result.getString("zip");
                }
                company_name_label.setText(companyName);
                company_address_label.setText(companyAddress);
                company_city_label.setText(companyCity);
                company_state_label.setText(companyCity);
                company_zip_label.setText(companyZip);
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
