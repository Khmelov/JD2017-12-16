package by.it.krasutski.jd03_02.crud;

import by.it.krasutski.jd03_02.database.ConnectionCreator;
import by.it.krasutski.jd03_02.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdCRUD implements BeanCRUD<Ad>{
    @Override
    public boolean create(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `ads` (`Title`, `SmallDesc`, `Description`, `Price`, `users_ID`, `category_ID`) " +
                            "VALUES ('%s', '%s', '%s', '%d', '%d', '%d');",
                    ad.getTitle(),ad.getSmallDesc(),ad.getDescription(),
                    ad.getPrice(),ad.getUsers_ID(),ad.getCategory_ID());
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
        ){
            String set = String.format("UPDATE `ads` SET Title='%s', SmallDesc='%s', Description='%s', Price='%d'," +
                            "users_ID='%d', category_ID='%d' WHERE users.ID='%d';",
                    ad.getTitle(),ad.getSmallDesc(),ad.getDescription(),
                    ad.getPrice(),ad.getUsers_ID(),ad.getCategory_ID());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public Ad read(int ID) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `ads` WHERE ID=%d;", ID);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Ad(
                        result.getInt("ID"),
                        result.getString("Title"),
                        result.getString("SmallDesc"),
                        result.getString("Description"),
                        result.getInt("Price"),
                        result.getInt("users_ID"),
                        result.getInt("category_ID"));
            }
        }
        return null;
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM ads WHERE ID=%d;", ad.getID());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
