package by.it.patsko.jd03_02.crud;

import by.it.patsko.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CatalogCRUD implements I_CRUD<Catalog> {

    @Override
    public boolean create(Catalog catalog) throws SQLException {
        catalog.setId(0);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("INSERT INTO `catalog`(`catalogName`) VALUES ('%s')",
                            catalog.getCatalogName()),
                    Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) catalog.setId(keys.getInt(1));
            }
            return recCount == 1;
        }
    }

    @Override
    public Catalog read(int id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet catalog = statement.executeQuery(
                    String.format("SELECT * FROM `catalog` WHERE id=%d", id));
            if (catalog.next()) {
                return new Catalog(
                        catalog.getInt("id"),
                        catalog.getString("catalogName")
                );
            }
        }
        return null;
    }

    @Override
    public boolean update(Catalog catalog) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("UPDATE `catalog` SET `name`='%s' WHERE id=%d",
                            catalog.getCatalogName(), catalog.getId()));
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Catalog catalog) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("DELETE FROM `catalog` WHERE id=%d", catalog.getId()));
            return recCount == 1;
        }
    }
}
