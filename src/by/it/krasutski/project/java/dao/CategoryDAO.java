package by.it.krasutski.project.java.dao;

import by.it.krasutski.project.java.entity.Category;
import by.it.krasutski.project.java.database.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements IDAO<Category> {
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
        List<Category> list = getAll(" where ID=" + ID);
        return list.size() > 0 ? list.get(0) : null;
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

    @Override
    public List<Category> getAll(String where) throws SQLException {
        List<Category> list = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from category " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Category category = new Category(
                    rs.getInt("ID"),
                    rs.getString("Name"));
            list.add(category);
        }
        return list;
    }
}
