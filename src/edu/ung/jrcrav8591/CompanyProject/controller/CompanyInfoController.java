package edu.ung.jrcrav8591.CompanyProject.controller;

import edu.ung.jrcrav8591.CompanyProject.SQLiteConnector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompanyInfoController {

    @FXML
    private Label company_name_label, company_address_label, company_city_label, company_zip_label, company_state_label;
    @FXML
    private TableView employee_tableview;



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
                    connection.close();
                }

                company_name_label.setText(companyName);
                company_address_label.setText(companyAddress);
                company_city_label.setText(companyCity);
                company_state_label.setText(companyState);
                company_zip_label.setText(companyZip);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            connection = SQLiteConnector.connect();
            String query = "SELECT * FROM Company";
            assert connection != null;
            ResultSet result = connection.createStatement().executeQuery(query);

            for(int i = 0; i < result.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn column = new TableColumn(result.getMetaData().getColumnName(i + 1));
                column.setCellFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new

                    SimpleStringProperty(param.getValue().get(j).toString());
                }
                });
                connection.close();
            }

            employee_tableview.getColumns().addAll(column);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void createNewEmployee(ActionEvent event){
        try {
            URL url = new File("src/edu/ung/jrcrav8591/CompanyProject/view/layout_employee.fxml").toURI().toURL();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Parent root = FXMLLoader.load(url);
            window.setTitle("Create New Employee");
            window.setScene(new Scene(root, 600, 400));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
