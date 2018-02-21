package by.it.sevashko.jd03_03.dao;

import by.it.sevashko.jd03_03.beans.Publication;
import by.it.sevashko.jd03_03.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublicationDAO extends AbstractDAO implements InterfaceDAO<Publication> {

    @Override
    public boolean create(Publication publication) throws SQLException {
        String insert = String.format("INSERT INTO `sevashko`.`publications` (`name`, `periodicity`, `minPeriod`, `price`) " +
                        "VALUES ('%s', '%d', '%d', '%s');",
                publication.getName(), publication.getPeriodicity(), publication.getMinPeriod(), publication.getPrice());
        int result = executeUpdate(insert);
        if (result > 0){
            publication.setId(result);
            return true;
        }
        return false;
    }

    @Override
    public Publication read(int id) throws SQLException {
        String query = String.format("SELECT * FROM `publications` WHERE publications.index='%d';", id);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                return new Publication(
                        result.getInt("index"),
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
        String set = String.format("UPDATE publications SET " +
                        "name='%s', periodicity='%d', minPeriod='%d', price='%s' WHERE publications.index='%d'",
                publication.getName(), publication.getPeriodicity(), publication.getMinPeriod(), publication.getPrice(),publication.getId());
        return executeUpdate(set) == 1;
    }

    @Override
    public boolean delete(Publication publication) throws SQLException {
        String query = String.format("DELETE FROM publications WHERE publications.index=%d;", publication.getId());
        return executeUpdate(query) == 1;
    }

    @Override
    public List<Publication> getALL(String where) throws SQLException {
        ArrayList<Publication> list = new ArrayList<>();
        String query = String.format("SELECT * FROM publications %s", where);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Publication publication = new Publication(
                        result.getInt("index"),
                        result.getString("name"),
                        result.getInt("periodicity"),
                        result.getInt("minPeriod"),
                        result.getFloat("price")
                );
                list.add(publication);
            }
        }
        return list;
    }
}
