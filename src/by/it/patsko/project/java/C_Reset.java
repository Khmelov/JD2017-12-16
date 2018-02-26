package by.it.patsko.project.java;

import by.it.patsko.project.java.dao.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = ConnectionCreator.getConnection()) {
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
