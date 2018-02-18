package by.it.sevashko.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    static void showUsers(){
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT login, name, lastName, role, email FROM sevashko.users"); //для запросов пользоателей
            Statement statement1 = connection.createStatement();  //для запрсов ролей
            while (result.next()){
                String login = result.getString("login");
                String name = result.getString("name");
                String lastname = result.getString(3);
                String email = result.getString("email");
                int roleNum = result.getInt(4);
                ResultSet result1 = statement1.executeQuery(String.format("SELECT role FROM sevashko.roles WHERE id=%d", roleNum));
                result1.next();
                String role = result1.getString(1);
                System.out.printf("Login: %s\nName: %s\nLastName: %s\nEmail: %s\nRole: %s\n\n", login, name, lastname, email, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
