package by.it.kozlov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/kozlov?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (DEFAULT, 1, '7 series', 'Седан', 164400, 2018, 1);"));
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (DEFAULT, 1, 'X6', 'Кроссовер', 132000, 2018, 1);"));
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (DEFAULT, 2, 'E 200 4MATIC', 'Седан', 137706, 2018, 2);"));
            statement.executeUpdate(String.format("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (DEFAULT, 2, 'GLS', 'Внедорожник', 164700, 2018, 2);"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
