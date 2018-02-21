package by.it.kozlov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/kozlov?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'admin');"));
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'user');"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
