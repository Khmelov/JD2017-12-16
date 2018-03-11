package by.it.patsko.project.java.dao.beanDao;

import by.it.patsko.project.java.dao.ConnectionCreator;
import by.it.patsko.project.java.dao.beens.Catalog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO extends DAO implements I_DAO<Catalog> {

    @Override
    public boolean create(Catalog catalog) throws SQLException {
        catalog.setId(0);
        int id = executeUpdate(String.format("INSERT INTO `catalog`(`catalogName`) VALUES ('%s')",
                catalog.getCatalogName()));
        if (id > 0) catalog.setId(id);
        return id > 0;
    }

    @Override
    public Catalog read(int id) throws SQLException {
        List<Catalog> catalogList = getAll(" where id='" + id + "'");
        return !catalogList.isEmpty() ? catalogList.get(0) : null;
    }

    @Override
    public boolean update(Catalog catalog) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `catalog` SET `catalogName`='%s' WHERE id=%d",
                        catalog.getCatalogName(), catalog.getId()));
    }

    @Override
    public boolean delete(Catalog catalog) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `catalog` WHERE id=%d", catalog.getId()));
    }

    @Override
    public List<Catalog> getAll(String where) throws SQLException {
        List<Catalog> catalogList = new ArrayList<>();
        String sql = "SELECT * FROM `catalog`" + where + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet catalogs = statement.executeQuery(sql)
        ) {
            while (catalogs.next()) {
                catalogList.add(
                        new Catalog(
                                catalogs.getInt("id"),
                                catalogs.getString("catalogName")
                        )
                );
            }
        }
        return catalogList;
    }
}
