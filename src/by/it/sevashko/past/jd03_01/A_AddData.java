package by.it.sevashko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    private static Statement statement;

    static void addData(){
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            statement = connection.createStatement();
            createPublications();
            createSubscriptions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createPublications() throws SQLException {
        statement.executeUpdate("INSERT INTO `sevashko`.`publications` (`name`, `periodicity`, `minPeriod`, `price`) " +
                "VALUES ('Автодайджест', '12', '1', '3.66');");
        statement.executeUpdate("INSERT INTO `sevashko`.`publications` (`name`, `periodicity`, `minPeriod`, `price`) " +
                "VALUES ('Транспортная безопасность', '24', '1', '13.45');");
        statement.executeUpdate("INSERT INTO `sevashko`.`publications` (`name`, `periodicity`, `minPeriod`, `price`) " +
                "VALUES ('Транспортный вестник', '26', '1', '14.85');");
    }

    private static void createSubscriptions() throws SQLException {
        statement.executeUpdate("INSERT INTO `sevashko`.`subscriptions` " +
                "(`user`, `publication`, `copies`, `period`, `start_subscription`, `end_subscription`, `price`)" +
                " VALUES ( '2', '1', '2', '4', '2018-01-01', '2018-03-30', '14.64');");
        statement.executeUpdate("INSERT INTO `sevashko`.`subscriptions` " +
                "(`user`, `publication`, `period`, `start_subscription`, `end_subscription`, `price`)" +
                " VALUES ( '2', '2', '4', '2018-01-01', '2018-03-30', '15.8');");
        statement.executeUpdate("INSERT INTO `sevashko`.`subscriptions` " +
                "(`user`, `publication`, `copies`, `period`, `start_subscription`, `end_subscription`, `price`)" +
                " VALUES ( '2', '3', '3', '4', '2018-01-01', '2018-03-30', '98.34');");
    }
}
