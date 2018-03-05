package by.it.krasutski.project.java.dao;

import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.database.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDAO implements IDAO<Ad> {

    @Override
    public boolean create(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String insert = String.format("INSERT INTO `ads` (`Title`, `SmallDesc`, `Description`, `Price`, `users_ID`, `category_ID`) " +
                            "VALUES ('%s', '%s', '%s', '%d', '%d', '%d');",
                    ad.getTitle(), ad.getSmallDesc(), ad.getDescription(),
                    ad.getPrice(), ad.getUsers_ID(), ad.getCategory_ID());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int ID = keys.getInt(1);
                    ad.setID(ID);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public boolean update(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String set = String.format("UPDATE `ads` SET Title='%s', SmallDesc='%s', Description='%s', Price='%d'," +
                            "users_ID='%d', category_ID='%d' WHERE users.ID='%d';",
                    ad.getTitle(), ad.getSmallDesc(), ad.getDescription(),
                    ad.getPrice(), ad.getUsers_ID(), ad.getCategory_ID());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public Ad read(int ID) throws SQLException {
        List<Ad> list = getAll(" where ID=" + ID);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = String.format("DELETE FROM ads WHERE ID=%d;", ad.getID());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }

    @Override
    public List<Ad> getAll(String where) throws SQLException {
        List<Ad> list = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from ads " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Ad ad = new Ad(
                    rs.getInt("ID"),
                    rs.getString("Title"),
                    rs.getString("SmallDesc"),
                    rs.getString("Description"),
                    rs.getInt("Price"),
                    rs.getInt("users_ID"),
                    rs.getInt("category_ID"));
            list.add(ad);
        }
        return list;
    }
}
