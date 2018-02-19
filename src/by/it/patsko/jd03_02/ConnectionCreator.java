package by.it.patsko.jd03_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())
                connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016/patsko"
                                + "?useUnicode=true&characterEncoding=UTF-8",
                        "root", ""
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
