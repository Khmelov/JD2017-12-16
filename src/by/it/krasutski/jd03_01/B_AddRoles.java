package by.it.krasutski.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class B_AddRoles {
    public static void main(String[] args) {
        addRoles();
    }

    public static void addRoles() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/krasutski" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                ""
        )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `krasutski`.`roles` (`Role`) " +
                    "VALUES ('Guest');");
            System.out.println("Role added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
