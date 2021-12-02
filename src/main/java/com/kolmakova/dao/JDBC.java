package com.kolmakova.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public JDBC(String userName, String userPassword, String dbURL) {
        connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, userName, userPassword);
            System.out.println("Connection created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet executeGetRequest(String query) throws SQLException {
       return connection.createStatement().executeQuery(query);
    }

    public void executeSetRequest(String query) throws SQLException {
        connection.createStatement().executeQuery(query);
    }
}
