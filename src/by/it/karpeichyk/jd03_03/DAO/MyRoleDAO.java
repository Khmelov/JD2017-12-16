package by.it.karpeichyk.jd03_03.DAO;


import by.it.karpeichyk.jd03_03.BEAN.Role;
import by.it.karpeichyk.jd03_03.ConnectWithDB.My_Connection_DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 21.02.2018.
 */
public class MyRoleDAO extends AbstractDAO_My implements DAO<Role> {
    @Override
    public boolean create(Role BEAN) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public boolean update(Role BEAN) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public boolean delete(Role BEAN) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> list = getAll("where ID=" + id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> list = new ArrayList<>();
        Connection connection = My_Connection_DB.getConnection();
        Statement statement = connection.createStatement();
        String sql="SELECT * from roles "+where+";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Role role = new Role(rs.getInt("ID"), rs.getNString("Role"));
            list.add(role);
        }

        return list;

    }
}
