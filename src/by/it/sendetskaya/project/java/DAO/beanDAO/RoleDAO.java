package by.it.sendetskaya.project.java.DAO.beanDAO;

import by.it.sendetskaya.project.java.entity.Role;
import by.it.sendetskaya.project.java.DAO.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IDAO<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public Role read(int id) throws SQLException {

        List<Role> list=getAll("WHERE ID="+id+" LIMIT 0,1");
        if(list.size()>0)
        {
            return list.get(0);
        }

        else
            return null;
    }

    @Override
    public List<Role> getAll() throws SQLException {

        List<Role> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.roles ;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Role role=new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                );
                list.add(role);
            }
        }

        return list;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {

        List<Role> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.roles "+where+ ";");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Role role=new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                );
                list.add(role);
            }
        }

        return list;
    }
}
