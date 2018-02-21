package by.it.krasutski.jd03_02.crud;

import by.it.krasutski.jd03_02.database.ConnectionCreator;
import by.it.krasutski.jd03_02.beans.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryCRUD implements BeanCRUD<Category> {
    @Override
    public boolean create(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `category` (`Name`) VALUES ('%s');",
                    category.getName());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int ID = keys.getInt(1);
                    category.setID(ID);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }

    @Override
    public Category read(int ID) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `category` WHERE ID=%d;", ID);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Category(
                        result.getInt("ID"),
                        result.getString("Name"));
            }
        }
        return null;
    }

    @Override
    public boolean delete(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM category WHERE ID=%d;", category.getID());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
