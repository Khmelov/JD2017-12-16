package by.it.kozlov.jd03_01;

import java.sql.*;

public class C_Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/kozlov?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM `cars` WHERE 1");
            statement.executeUpdate("DELETE FROM `users` WHERE 1");
            statement.executeUpdate("DELETE FROM `brand` WHERE 1");
            statement.executeUpdate("DELETE FROM `city` WHERE 1");
            statement.executeUpdate("DELETE FROM `roles` WHERE 1");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
