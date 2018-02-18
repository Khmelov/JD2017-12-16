package by.it.patsko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(Connect.URL_DB, Connect.USER_DB, Connect.PASSWORD_DB)) {
                Statement statement=connection.createStatement();
                statement.executeUpdate(
                        "INSERT INTO `buyers`(`login`, `password`, `email`, `Roles_id`)" +
                                "VALUES ('buyer3','пароль','buyer3@buyer.by','2')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
