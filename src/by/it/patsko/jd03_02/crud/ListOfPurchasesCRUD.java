package by.it.patsko.jd03_02.crud;

import by.it.patsko.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListOfPurchasesCRUD implements I_CRUD<ListOfPurchases> {

    @Override
    public boolean create(ListOfPurchases list) throws SQLException {
        list.setId(0);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("INSERT INTO `list of purchases`(`Buyers_id`, `Books_id`)" +
                                    "VALUES ('%d','%d')",
                            list.getBuyers_id(), list.getBooks_id()),
                    Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) list.setId(keys.getInt(1));
            }
            return recCount == 1;
        }
    }

    @Override
    public ListOfPurchases read(int id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet list = statement.executeQuery(
                    String.format("SELECT * FROM `list of purchases` WHERE id=%d", id));
            if (list.next()) {
                return new ListOfPurchases(
                        list.getInt("id"),
                        list.getInt("Buyers_id"),
                        list.getInt("Books_id")
                );
            }
        }
        return null;
    }

    @Override
    public boolean update(ListOfPurchases list) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("UPDATE `list of purchases`" +
                                    "SET `Buyers_id`='%d',`Books_id`='%d' WHERE id=%d",
                            list.getBuyers_id(), list.getBooks_id(), list.getId()));
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(ListOfPurchases list) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("DELETE FROM `list of purchases` WHERE id=%d", list.getId()));
            return recCount == 1;
        }
    }
}
