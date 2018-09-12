package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import edu.ung.jrcrav8591.CompanyProject.model.EmployeeTable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompanyInfoController{

    @FXML
    private Label company_name_label, company_address_label, company_city_label;
    @FXML
    private TableView<EmployeeTable> employee_tableview, supervisor_tableview;
    @FXML
    private TableColumn<EmployeeTable, String> column_first_name, column_last_name, column_social, column_phone, column_email, column_dob, column_start_date;
    @FXML
    private TableColumn<EmployeeTable, String> column_super_first_name, column_super_last_name, column_super_social,
            column_super_phone, column_super_email, column_super_dob, column_super_start_date;
    @FXML
    private MenuItem close_menu_item;

    //Initialize method to fill Table Views and Company Information
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
                company_city_label.setText(companyCity + ", " + companyState + " " + companyZip);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        fillEmployeeTableView();
        fillSupervisorTableView();
    }

    //Fills the employee tab table view with all employees, including supervisors
    private void fillEmployeeTableView(){
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

    //Fills the supervisor tab table view with employees who are also supervisors
    private void fillSupervisorTableView(){
        assert supervisor_tableview != null;
        column_super_first_name.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        column_super_last_name.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        column_super_social.setCellValueFactory(
                new PropertyValueFactory<>("social")
        );
        column_super_phone.setCellValueFactory(
                new PropertyValueFactory<>("phone")
        );
        column_super_email.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );
        column_super_dob.setCellValueFactory(
                new PropertyValueFactory<>("dob")
        );
        column_super_start_date.setCellValueFactory(
                new PropertyValueFactory<>("startDate")
        );

        ObservableList<EmployeeTable> data = FXCollections.observableArrayList();
        try{
            Connection connection = SQLiteConnector.connect();
            String query = "SELECT * FROM Employees WHERE supervisor = '1' ";
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
            supervisor_tableview.setItems(data);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    //Loads the new employee layout
    public void createNewEmployee(){
        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_employee.fxml").toURI().toURL();

            Stage window = new Stage();
            Parent root = FXMLLoader.load(url);
            window.setTitle("Create New Employee");
            window.setScene(new Scene(root, 600, 400));
            window.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(){
        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_delete_employee.fxml").toURI().toURL();

            Stage window = new Stage();
            Parent root = FXMLLoader.load(url);
            window.setTitle("Create New Employee");
            window.setScene(new Scene(root, 600, 400));
            window.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Loads the New Company layout
    public void createNewCompany(){
        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_new_company.fxml").toURI().toURL();

            Stage window = new Stage();
            Parent root = FXMLLoader.load(url);
            window.setTitle("Create New Company");
            window.setScene(new Scene(root, 600, 400));
            window.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void refreshTables(){
        fillEmployeeTableView();
        fillSupervisorTableView();
    }

    public void close(){
        close_menu_item.setMnemonicParsing(true);
        Platform.exit();
    }
}
