package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import edu.ung.jrcrav8591.CompanyProject.model.Employee;
import edu.ung.jrcrav8591.CompanyProject.model.EmployeeTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CompanyInfoController{

    @FXML
    private Label company_name_label, company_address_label, company_city_label, company_zip_label, company_state_label;
    @FXML
    private TableView<EmployeeTable> employee_tableview;
    @FXML
    private TableColumn<EmployeeTable, String> column_first_name;
    @FXML
    private TableColumn<EmployeeTable, String> column_last_name;
    @FXML
    private TableColumn<EmployeeTable, String> column_social;
    @FXML
    private TableColumn<EmployeeTable, String> column_phone;
    @FXML
    private TableColumn<EmployeeTable, String> column_email;
    @FXML
    private TableColumn<EmployeeTable, String> column_dob;
    @FXML
    private TableColumn<EmployeeTable, String> column_start_date;

    @FXML
    private void initialize() {
        Connection connection;
        try {
            //Query to print company info on the Main page
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
                connection.close();
                company_name_label.setText(companyName);
                company_address_label.setText(companyAddress);
                company_city_label.setText(companyCity);
                company_state_label.setText(companyState);
                company_zip_label.setText(companyZip);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assert employee_tableview != null;
        column_first_name.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        column_last_name.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        column_social.setCellValueFactory(
                new PropertyValueFactory<>("social")
        );
        column_phone.setCellValueFactory(
                new PropertyValueFactory<>("phone")
        );
        column_email.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );
        column_dob.setCellValueFactory(
                new PropertyValueFactory<>("dob")
        );
        column_start_date.setCellValueFactory(
                new PropertyValueFactory<>("startDate")
        );

        try{
            employeeData();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void employeeData(){
        ObservableList<EmployeeTable> data = FXCollections.observableArrayList();
        try{
            Connection connection = SQLiteConnector.connect();
            String query = "SELECT * FROM Employees";
            assert connection != null;
            ResultSet result = connection.createStatement().executeQuery(query);
            while(result.next()){
                EmployeeTable table = new EmployeeTable();
                table.firstName.set(result.getString("firstName"));
                table.lastName.set(result.getString("lastName"));
                table.social.set(result.getString("social"));
                table.phone.set(result.getString("phone"));
                table.email.set(result.getString("email"));
                table.dob.set(result.getString("dob"));
                table.startDate.set(result.getString("startDate"));
                data.add(table);
            }
            employee_tableview.setItems(data);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //Loads the new employee layout
    public void createNewEmployee(ActionEvent event){
        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_employee.fxml").toURI().toURL();

            Stage window = new Stage();
            window.initModality(Modality.WINDOW_MODAL);
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(url);
            window.setTitle("Create New Employee");
            window.setScene(new Scene(root, 600, 400));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void createNewCompany(ActionEvent event){
        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_main.fxml").toURI().toURL();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Parent root = FXMLLoader.load(url);
            window.setTitle("Create New Company");
            window.setScene(new Scene(root, 600, 400));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
