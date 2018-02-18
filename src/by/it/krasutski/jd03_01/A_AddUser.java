package by.it.krasutski.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddUser {
    public static void main(String[] args) {
        addUser();
    }

    public static void addUser() {
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
            statement.executeUpdate("INSERT INTO `krasutski`.`users` (`Login`, `Password`, `Email`, `Nickname`, `PhoneNumber`, `roles_ID`) " +
                    "VALUES ('vasili', 'vas19ji', 'vasbest@it.by', 'Vasiliy1345', '+375447435348', 2);");
            System.out.println("User added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
