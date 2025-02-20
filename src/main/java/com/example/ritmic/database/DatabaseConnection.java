package com.example.ritmic.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=RitmicPrototip1;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "Alex2004Razvan";

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args){
        try (Connection conn = connect()){
            System.out.println("Connected to the database!");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
