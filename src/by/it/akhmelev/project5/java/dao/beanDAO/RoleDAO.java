package by.it.akhmelev.project5.java.dao.beanDAO;


import by.it.akhmelev.project5.java.dao.bean.Role;
import by.it.akhmelev.project5.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author i.sukach
 */
public class RoleDAO implements InterfaceDAO<Role> {
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
        List<Role> list=getAll(" where ID="+id);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> list=new ArrayList<>();
        Connection connection= ConnectionCreator.getConnection();
        Statement statement=connection.createStatement();
        String sql="SELECT * from roles "+where+";";
        ResultSet rs=statement.executeQuery(sql);
        while (rs.next()){
            Role role=new Role(rs.getInt("ID"),rs.getString("Role"));
            list.add(role);
        }
        return list;
    }
}
