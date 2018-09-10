package edu.ung.jrcrav8591.CompanyProject;

import org.sqlite.SQLiteConnection;

import java.sql.*;

public class SQLiteConnector {
    public static Connection connect() {
        Connection connection;
        try{
            DriverManager.registerDriver(new org.sqlite.JDBC());
            String url = "jdbc:sqlite:src/companydata.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Database connection established");

            //Create company table if needed
            String createCompanyTable = "CREATE TABLE IF NOT EXISTS `Company` (\n" +
                    "\t`name`\tTEXT,\n" +
                    "\t`address`\tTEXT,\n" +
                    "\t`address2`\tTEXT,\n" +
                    "\t`city`\tTEXT,\n" +
                    "\t`state`\tTEXT,\n" +
                    "\t`zip`\tTEXT\n" +
                    ");";

            String createEmployeesTable = "CREATE TABLE IF NOT EXISTS `Employees` (\n" +
                    "\t`firstName`\tTEXT,\n" +
                    "\t`lastName`\tTEXT,\n" +
                    "\t`social`\tTEXT,\n" +
                    "\t`phone`\tTEXT,\n" +
                    "\t`email`\tTEXT,\n" +
                    "\t`dob`\tSMALLDATETIME,\n" +
                    "\t`startDate`\tSMALLDATETIME\n" +
                    ");";

            Statement statement;
            if(connection != null){
                statement = connection.createStatement();
                statement.executeUpdate(createCompanyTable);
                statement.executeUpdate(createEmployeesTable);
            }

            return connection;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
