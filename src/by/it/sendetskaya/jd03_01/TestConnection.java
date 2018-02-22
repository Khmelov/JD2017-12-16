package by.it.sendetskaya.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {
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

        try (Connection connection = DriverManager.getConnection
                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)){
         if ((!connection.isClosed()))
             System.out.println("Соединение установлено");
         connection.close();
         if (connection.isClosed())
             System.out.println("Соединение прервано");
         }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
