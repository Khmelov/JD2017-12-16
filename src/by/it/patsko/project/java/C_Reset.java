package by.it.patsko.project.java;

import by.it.patsko.project.java.dao.ConnectionCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`List of purchases` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Books` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Category` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Catalog` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Buyers` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Roles` ;");
//            statement.executeUpdate("DROP SCHEMA IF EXISTS `patsko` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
