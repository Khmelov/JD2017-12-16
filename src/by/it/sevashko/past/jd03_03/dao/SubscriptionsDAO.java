package by.it.sevashko.jd03_03.dao;

import by.it.sevashko.jd03_03.beans.Subscription;
import by.it.sevashko.jd03_03.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionsDAO extends AbstractDAO implements InterfaceDAO<Subscription> {

    @Override
    public boolean create(Subscription subscription) throws SQLException {
        String insert = String.format("INSERT INTO `sevashko`.`subscriptions` " +
                        "(`user`, `publication`, `copies`, `period`, `start_subscription`, `end_subscription`, `price`)" +
                        " VALUES ( '%d', '%d', '%d', '%d', '%s', '%s', '%s');",
                subscription.getUser(), subscription.getPublication(), subscription.getCopies(),
                subscription.getPeriod(), subscription.getStart_subscription(), subscription.getEnd_subscription(),
                subscription.getPrice());
        int result = executeUpdate(insert);
        if (result > 0){
            subscription.setId(result);
            return true;
        }
        return false;
    }

    @Override
    public Subscription read(int id) throws SQLException {
        String query = String.format("SELECT * FROM `subscriptions` WHERE id=%d;", id);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                return new Subscription(
                        result.getInt("id"),
                        result.getInt("user"),
                        result.getInt("publication"),
                        result.getInt("copies"),
                        result.getInt("period"),
                        result.getDate("start_subscription"),
                        result.getDate("end_subscription"),
                        result.getFloat("price"));
            }
        }
        return null;
    }

    @Override
    public boolean update(Subscription subscription) throws SQLException {
        String set = String.format("UPDATE `subscriptions` SET user='%d', publication='%d', copies='%d', " +
                        "period='%d', start_subscription='%s', end_subscription='%s', price='%s' WHERE id='%d';",
                subscription.getUser(), subscription.getPublication(), subscription.getCopies(),
                subscription.getPeriod(), subscription.getStart_subscription(), subscription.getEnd_subscription(),
                subscription.getPrice(), subscription.getId());
        return executeUpdate(set) == 1;
    }

    @Override
    public boolean delete(Subscription subscription) throws SQLException {
        String query = String.format("DELETE FROM subscriptions WHERE id=%d;", subscription.getId());
        return executeUpdate(query) == 1;
    }

    @Override
    public List<Subscription> getALL(String where) throws SQLException {
        ArrayList<Subscription> list = new ArrayList<>();
        String query = String.format("SELECT * FROM subscriptions %s", where);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Subscription subscription = new Subscription(
                        result.getInt("id"),
                        result.getInt("user"),
                        result.getInt("publication"),
                        result.getInt("copies"),
                        result.getInt("period"),
                        result.getDate("start_subscription"),
                        result.getDate("end_subscription"),
                        result.getFloat("price"));
                list.add(subscription);
            }
        }
        return list;
    }
}
