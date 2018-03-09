package by.it.sevashko.project.java.dao.beanDAO;

import by.it.sevashko.project.java.entities.Role;
import by.it.sevashko.project.java.dao.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        throw new SQLException("Not implement");
    }

    @Override
    public Role read(int id) throws SQLException {
        String query = String.format("SELECT * FROM `roles` WHERE id=%d;", id);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                return new Role(
                        result.getInt("id"),
                        result.getString("role"));
            }
        }
        return null;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        throw new SQLException("Not implement");
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        throw new SQLException("Not implement");
    }

    @Override
    public List<Role> getALL(String where) throws SQLException {
        ArrayList<Role> list = new ArrayList<>();
        String query = String.format("SELECT * FROM roles %s", where);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Role role = new Role(
                        result.getInt("id"),
                        result.getString("role"));
                list.add(role);
            }
        }
        return list;
    }
}
