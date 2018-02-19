package by.it.sendetskaya.jd03_02;

import java.sql.*;

public class Role_CRUD implements IBean_CRUD <Role>{

    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(int id) throws SQLException {

        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.roles WHERE" +
                    " ID=%d",id);

            final ResultSet resultSet=statement.executeQuery(sql);

            if (resultSet.next())
            {
                return new Role (
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                );
            }
        }

        return null;
    }

    @Override
    public Role readAll() throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.roles;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int countColumn=resultSetMetaData.getColumnCount();
                for (int i = 1; i < countColumn+1; i++) {
                       System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
                                resultSet.getString(i)+" ");
                }
                System.out.println();
            }
        }

        return null;
    }
}
