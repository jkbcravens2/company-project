package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompanyInfoController {

    @FXML
    private Label company_name_label;

    @FXML
    private void initialize(){

        Connection connection;
        try {
            String companyNameQuery = "SELECT NAME FROM Company LIMIT 1;";
            String companyName = "";
            connection = SQLiteConnector.connect();
            Statement statement;
            if(connection != null){
                statement = connection.createStatement();
                statement.executeQuery(companyNameQuery);
                ResultSet result = statement.executeQuery(companyNameQuery);
                while(result.next()){
                    companyName = result.getString("name");
                }
                company_name_label.setText(companyName);
                connection.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
