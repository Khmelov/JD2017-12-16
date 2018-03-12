package by.it.vshelukhin.jd03_06.java.dao.connection;

import by.it.vshelukhin.jd03_06.java.dao.connection.MySet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect implements MySet {


    static Connection connection;

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (connection == null || connection.isClosed()){
            synchronized (MyConnect.class){
                if (connection == null || connection.isClosed()){
                    connection = DriverManager.getConnection(URL_DB,USER_DB, PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
