package by.it.viktorbrui.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testConection {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016/viktorbrui?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO `user` (`ID`, `nickname`, `email`, `password`, `address`, `phone`, `FK_Roles`) VALUES (NULL, 'User', 'User@mail.ru', 'User1234', 'UserCenter', '2222222', '2') "));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
