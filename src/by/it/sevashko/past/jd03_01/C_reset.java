package by.it.sevashko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_reset{

    static void dropAll(){
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016/?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            Statement statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE IF EXISTS `sevashko`.`subscriptions`;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `sevashko`.`publications`;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `sevashko`.`users` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `sevashko`.`roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `sevashko` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
