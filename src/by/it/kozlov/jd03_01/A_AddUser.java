package by.it.kozlov.jd03_01;

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

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/kozlov?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`users` (`ID`, `Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES (DEFAULT, 'bayernkraft.by', 'bmw.service@bayernkraft.by', 'bayernkraft', 7, 'ул. Панченко, 9', '+375447730077', 2);"));
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`users` (`ID`, `Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES (DEFAULT, 'mercedes-benz.by', 'info@mercedes-benz.by', 'mercedes', 7, 'ул. Тимирязева, 70', '+375296039999', 2);"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
