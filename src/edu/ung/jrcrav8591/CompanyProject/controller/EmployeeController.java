package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import edu.ung.jrcrav8591.CompanyProject.model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.net.URL;
import java.sql.PreparedStatement;

public class EmployeeController {

    @FXML
    private TextField employee_first_name_text, employee_last_name_text, employee_social_text, employee_phone_text, employee_email_text;
    @FXML
    private DatePicker employee_dob_date, employee_start_date;

    public void addNewEmployee(ActionEvent event){

        String employeeFirstName = employee_first_name_text.getText();
        String employeeLastName = employee_last_name_text.getText();
        String employeeSocial = employee_social_text.getText();
        String employeePhone = employee_phone_text.getText();
        String employeeEmail = employee_email_text.getText();
        String employeeDob = employee_dob_date.toString();
        String employeeStartDate = employee_start_date.toString();

        Employee employee = new Employee(employeeFirstName, employeeLastName, employeeSocial, employeePhone, employeeEmail, employeeDob, employeeStartDate);

        Connection connection;
        try {
            String query = "INSERT INTO Employees VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement;
            connection = SQLiteConnector.connect();
            if(connection != null){
                statement = connection.prepareStatement(query);
                statement.setString(1, employee.getFirstName());
                statement.setString(2, employee.getLastName());
                statement.setString(3, employee.getSocial());
                statement.setString(4, employee.getPhone());
                statement.setString(5, employee.getEmail());
                statement.setString(6, employee.getDob());
                statement.setString(7, employee.getStartDate());
                statement.executeUpdate();
                connection.close();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_company_info.fxml").toURI().toURL();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Parent root = FXMLLoader.load(url);
            window.setTitle("Company Info");
            window.setScene(new Scene(root, 1031, 645));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
