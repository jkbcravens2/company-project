package edu.ung.jrcrav8591.CompanyProject;

import org.sqlite.SQLiteConnection;

import java.sql.*;

public class SQLiteConnector {
    public static Connection connect() {
        Connection connection;
        try{
            DriverManager.registerDriver(new org.sqlite.JDBC());
            String url = "jdbc:sqlite:C:\\Users\\jkbcravens2\\IdeaProjects\\company-project\\companydata.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Database connection established");

            return connection;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
