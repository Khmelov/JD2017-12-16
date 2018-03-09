package by.it.sevashko.jd03_03.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {

    public static void addRoles(){
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `sevashko`.`roles` (`role`) VALUES ('Админитратор');");
            statement.executeUpdate("INSERT INTO `sevashko`.`roles` (`role`) VALUES ('Подписчик');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
