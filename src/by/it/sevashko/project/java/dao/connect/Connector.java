package by.it.sevashko.project.java.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private final static String URL_DB = "jdbc:mysql://localhost:2016/sevashko?useUnicode=true&characterEncoding=UTF-8";
    private final static String USER_DB = "root";
    private final static String PASSWORD_DB = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
