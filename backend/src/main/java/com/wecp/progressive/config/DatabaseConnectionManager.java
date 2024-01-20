package com.wecp.progressive.config;
import java.sql.*;
import java.sql.Connection;

public class DatabaseConnectionManager {

    private static String url="jdbc:mysql://localhost:3306/banksafe_wecp";
    private static String username="root";
    private static String password="root";

    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }
    
}
