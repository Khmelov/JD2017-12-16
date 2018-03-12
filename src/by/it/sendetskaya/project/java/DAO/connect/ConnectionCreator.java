package by.it.sendetskaya.project.java.DAO.connect;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver= null;
            try {
                driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try {
            if (connection==null||connection.isClosed())
                connection= DriverManager.getConnection(
                        CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
