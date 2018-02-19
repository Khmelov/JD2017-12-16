package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.Helpers.Connector;
import by.it.sevashko.jd03_02.beans.Publication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PublicationCRUD implements CRUD<Publication> {

    @Override
    public boolean create(Publication publication) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `sevashko`.`publications` (`name`, `periodicity`, `minPeriod`, `price`) " +
                            "VALUES ('%s', '%d', '%d', '%f');",
                    publication.getName(), publication.getPeriodicity(), publication.getMinPeriod(), publication.getPrice());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    publication.setId(id);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public Publication read(int id) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `publications` WHERE id=%d;", id);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Publication(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("periodicity"),
                        result.getInt("minPeriod"),
                        result.getFloat("price")
                );
            }
        }
        return null;
    }

    @Override
    public boolean update(Publication publication) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String set = String.format("UPDATE publications SET " +
                            "name='%s', periodicity='%d', minPeriod='%d', price='%f'",
                    publication.getName(), publication.getPeriodicity(), publication.getMinPeriod(), publication.getPrice());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Publication publication) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM publications WHERE id=%d;", publication.getId());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
