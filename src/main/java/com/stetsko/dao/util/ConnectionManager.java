package com.stetsko.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(PropertiesManager.get(URL_KEY),
                    PropertiesManager.get(USERNAME_KEY),
                    PropertiesManager.get(PASSWORD_KEY));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
