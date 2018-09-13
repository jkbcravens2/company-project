package edu.ung.jrcrav8591.CompanyProject;

import java.sql.*;

public class SQLiteConnector {
    public static Connection connect() {
        Connection connection;
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            String url = "jdbc:sqlite:src/companydata.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Database connection established");
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

