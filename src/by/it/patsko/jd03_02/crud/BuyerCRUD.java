package by.it.patsko.jd03_02.crud;

import by.it.patsko.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuyerCRUD implements I_CRUD<Buyer> {

    @Override
    public boolean create(Buyer buyer) throws SQLException {
        buyer.setId(0);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("INSERT INTO `buyers`(`login`, `password`, `email`, `Roles_id`) " +
                                    "VALUES ('%s','%s','%s','%d')",
                            buyer.getLogin(), buyer.getPassword(), buyer.getEmail(), buyer.getRoles_id()),
                    Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) buyer.setId(keys.getInt(1));
            }
            return recCount == 1;
        }
    }

    @Override
    public Buyer read(int id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet buyers = statement.executeQuery(
                    String.format("SELECT * FROM `buyers` WHERE id=%d", id));
            if (buyers.next()) {
                return new Buyer(
                        buyers.getInt("id"),
                        buyers.getString("login"),
                        buyers.getString("password"),
                        buyers.getString("email"),
                        buyers.getInt("Roles_id")
                );
            }
        }
        return null;
    }

    @Override
    public boolean update(Buyer buyer) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("UPDATE `buyers` SET `login`='%s',`password`='%s',`email`='%s',`Roles_id`='%d' WHERE id=%d",
                    buyer.getLogin(), buyer.getPassword(),buyer.getEmail(),buyer.getRoles_id(),buyer.getId()));
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Buyer buyer) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("DELETE FROM `buyers` WHERE id=%d", buyer.getId()));
            return recCount == 1;
        }
    }
}
