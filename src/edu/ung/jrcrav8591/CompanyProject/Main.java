package edu.ung.jrcrav8591.CompanyProject;

import edu.ung.jrcrav8591.CompanyProject.controller.CompanyInfoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/layout_company_info.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1031, 645));
        primaryStage.show();
        createTables();

        /*try{
            String drop = "DROP TABLE Employees";
            Connection connection = SQLiteConnector.connect();
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.executeUpdate(drop);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
    }

    private void createTables(){
        Connection connection;
        Statement statement, statement2;
        try{
            String companyQuery = "CREATE TABLE IF NOT EXISTS Company(" +
                    "name TEXT, address TEXT, address2 TEXT, city TEXT, state TEXT, zip TEXT);";
            String employeeQuery = "CREATE TABLE IF NOT EXISTS Employees(" +
                    "firstName TEXT, lastName TEXT, social TEXT, phone TEXT, " +
                    "email TEXT, dob SMALLDATETIME, startDate SMALLDATETIME, isSupervisor BOOLEAN);";
            connection = SQLiteConnector.connect();
            assert connection != null;
            statement = connection.createStatement();
            statement.executeUpdate(companyQuery);

            statement2 = connection.createStatement();
            statement2.executeUpdate(employeeQuery);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
