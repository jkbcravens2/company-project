package edu.ung.jrcrav8591.CompanyProject.controller;

import java.sql.*;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import edu.ung.jrcrav8591.CompanyProject.model.Company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class Controller {

    @FXML
    private TextField company_name_text, company_address_text, company_address2_text, company_city_text,
        company_state_text, company_zip_text;

    public void createCompanyBtn(ActionEvent event){

        String newCompanyName = company_name_text.getText();
        String newCompanyAddress = company_address_text.getText();
        String newCompanyAddress2 = company_address2_text.getText();
        String newCompanyCity = company_city_text.getText();
        String newCompanyState = company_state_text.getText();
        String newCompanyZip =  company_zip_text.getText();

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
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
