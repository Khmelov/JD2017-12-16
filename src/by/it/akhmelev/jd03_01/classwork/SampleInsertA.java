package by.it.akhmelev.jd03_01.classwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleInsertA {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016/akhmelev?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO `ads` (`ID`, `Description`, `Address`, `Flool`, `Floors`, `RoomCount`, `Price`, `Area`, `FK_users`) VALUES (DEFAULT, 'Good price', 'Lenina 1', 1, 1, 1, 111111, 111, 2);"));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
