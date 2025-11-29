package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    // Method to establish and return a database connection
    public static Connection getConnection() throws SQLException {
        // Load the MySQL JDBC driver (only required in older versions of Java)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        }

        // Create and return the connection
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}