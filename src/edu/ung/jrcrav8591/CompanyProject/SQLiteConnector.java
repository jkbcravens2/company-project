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

            //Create company table if needed
            String createCompanyTable = "CREATE TABLE IF NOT EXISTS `Company` (\n" +
                    "\t`name`\tTEXT,\n" +
                    "\t`address`\tTEXT,\n" +
                    "\t`address2`\tTEXT,\n" +
                    "\t`city`\tTEXT,\n" +
                    "\t`state`\tTEXT,\n" +
                    "\t`zip`\tTEXT\n" +
                    ");";

            Statement statement;
            if(connection != null){
                statement = connection.createStatement();
                statement.executeUpdate(createCompanyTable);
            }

            return connection;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
