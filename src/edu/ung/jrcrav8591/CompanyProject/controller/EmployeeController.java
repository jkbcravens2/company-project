package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import edu.ung.jrcrav8591.CompanyProject.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EmployeeController {

    @FXML
    private TextField employee_first_name_text, employee_last_name_text, employee_social_text, employee_phone_text, employee_email_text;
    @FXML
    private TextField delete_first_text, delete_last_text;
    @FXML
    private DatePicker employee_dob_date, employee_start_date;
    @FXML
    private CheckBox supervisor_checkbox;

    public void addNewEmployee(ActionEvent event){

        String employeeFirstName = employee_first_name_text.getText();
        String employeeLastName = employee_last_name_text.getText();
        String employeeSocial = employee_social_text.getText();
        String employeePhone = employee_phone_text.getText();
        String employeeEmail = employee_email_text.getText();
        String employeeDob = employee_dob_date.getValue().toString();
        String employeeStartDate = employee_start_date.getValue().toString();
        Boolean supervisor = supervisor_checkbox.isSelected();

        Employee employee = new Employee(employeeFirstName, employeeLastName, employeeSocial, employeePhone, employeeEmail, employeeDob, employeeStartDate, supervisor);

        Connection connection;
        try {
            String query = "INSERT INTO Employees VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement;
            connection = SQLiteConnector.connect();
            assert connection != null;
                statement = connection.prepareStatement(query);
                statement.setString(1, employee.getFirstName());
                statement.setString(2, employee.getLastName());
                statement.setString(3, employee.getSocial());
                statement.setString(4, employee.getPhone());
                statement.setString(5, employee.getEmail());
                statement.setString(6, employee.getDob());
                statement.setString(7, employee.getStartDate());
                statement.setBoolean(8, employee.isSupervisor());
                statement.executeUpdate();
                connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

       try {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee(ActionEvent event){
        String firstName = delete_first_text.getText();
        String lastName = delete_last_text.getText();

        try{
            Connection connection = SQLiteConnector.connect();
            String deleteQuery = "DELETE FROM Employees WHERE firstName = ? and lastName = ?";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.executeUpdate();
            connection.close();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void cancel(ActionEvent event){
        try {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
