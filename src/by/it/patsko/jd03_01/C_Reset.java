package by.it.patsko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(Connect.URL_DB, Connect.USER_DB, Connect.PASSWORD_DB)) {
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
