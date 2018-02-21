package by.it.patsko.jd03_02.crud;

import by.it.patsko.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryCRUD implements I_CRUD<Category> {

    @Override
    public boolean create(Category category) throws SQLException {
        category.setId(0);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("INSERT INTO `category`(`CategoryName`, `Catalog_id`)" +
                                    "VALUES ('%s','%d')",
                            category.getCategoryName(),category.getCatalog_id()),
                    Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) category.setId(keys.getInt(1));
            }
            return recCount == 1;
        }
    }

    @Override
    public Category read(int id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet category = statement.executeQuery(
                    String.format("SELECT * FROM `category` WHERE id=%d", id));
            if (category.next()) {
                return new Category(
                        category.getInt("id"),
                        category.getString("CategoryName"),
                        category.getInt("Catalog_id")
                );
            }
        }
        return null;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("UPDATE `category`" +
                                    "SET `CategoryName`='%s',`Catalog_id`='%d'" +
                                    "WHERE id=%d",
                    category.getCategoryName(),category.getCatalog_id(),category.getId()));
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("DELETE FROM `category` WHERE id=%d", category.getId()));
            return recCount == 1;
        }
    }
}
