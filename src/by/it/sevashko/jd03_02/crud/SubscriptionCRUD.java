package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.helpers.Connector;
import by.it.sevashko.jd03_02.beans.Subscription;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubscriptionCRUD implements CRUD<Subscription> {

    @Override
    public boolean create(Subscription subscription) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `sevashko`.`subscriptions` " +
                            "(`user`, `publication`, `copies`, `period`, `start_subscription`, `end_subscription`, `price`)" +
                            " VALUES ( '%d', '%d', '%d', '%d', '%s', '%s', '%s');",
                    subscription.getUser(), subscription.getPublication(), subscription.getCopies(),
                    subscription.getPeriod(), subscription.getStart_subscription(), subscription.getEnd_subscription(),
                    subscription.getPrice());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    subscription.setId(id);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public Subscription read(int id) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `subscriptions` WHERE id=%d;", id);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Subscription(
                        result.getInt("id"),
                        result.getInt("user"),
                        result.getInt("publication"),
                        result.getInt("copies"),
                        result.getInt("period"),
                        result.getDate("start_subscriptio"),
                        result.getDate("end_subscription"),
                        result.getFloat("price"));
            }
        }
        return null;
    }

    @Override
    public boolean update(Subscription subscription) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String set = String.format("UPDATE `subscriptions` SET `user='%d'`, `publication='%d'`, `copies='%d'`, " +
                            "`period='%d'`, `start_subscription='%s'`, `end_subscription='%s'`, `price='%f'` WHERE id='%d';",
                    subscription.getUser(), subscription.getPublication(), subscription.getCopies(),
                    subscription.getPeriod(), subscription.getStart_subscription(), subscription.getEnd_subscription(),
                    subscription.getPrice(), subscription.getId());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Subscription subscription) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM subscriptions WHERE id=%d;", subscription.getId());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
