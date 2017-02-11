/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.technique;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mehdi
 */
public class DataSource {

    private String url = "jdbc:mysql://localhost:3306/test";
    private String login = "root";
    private String password = "";
    private Connection connection;
    private static DataSource dataSource;

    private DataSource() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }
}
