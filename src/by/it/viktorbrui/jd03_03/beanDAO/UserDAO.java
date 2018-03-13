package by.it.viktorbrui.jd03_03.beanDAO;

import by.it.viktorbrui.jd03_02.ConnectionCreator;
import by.it.viktorbrui.jd03_03.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public boolean create(User user) throws SQLException {
        user.setId(0);
        String sql = String.format(
                "INSERT INTO `users`(`Nickname`, `Email`, `Password`, `Address`, `Phone`, `FK_Roles`)" +
                        " VALUES ('%s','%s','%s',%d)",
                user.getNickname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getFK_Roles());
        int id = executeUpdate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        } else
            return false;
    }


    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET `Nickname`='%s',`Email`='%s', `Password`='%s', " +
                        "`Address`='%s',`Phone`='%s',`FK_Roles`=%d WHERE ID=%d",
                user.getNickname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(),
                user.getFK_Roles(), user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE ID=%d",
                user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> list = getAll(" where ID=" + id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> list = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from users " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            User user = new User(
                    rs.getInt("ID"),
                    rs.getString("Nickname"),
                    rs.getString("Email"),
                    rs.getString("Address"),
                    rs.getString("Phone"),
                    rs.getInt("FK_Roles")
            );
            list.add(user);
        }
        return list;
    }
}
