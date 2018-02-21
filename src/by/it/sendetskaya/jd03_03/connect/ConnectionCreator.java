package by.it.sendetskaya.jd03_03.connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static Connection connection;

    public static Connection getConnection() {
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
