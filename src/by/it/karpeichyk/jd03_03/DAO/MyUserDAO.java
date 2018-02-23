package by.it.karpeichyk.jd03_03.DAO;


import by.it.karpeichyk.jd03_03.BEAN.User;
import by.it.karpeichyk.jd03_03.ConnectWithDB.My_Connection_DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22.02.2018.
 */
public class MyUserDAO extends  AbstractDAO_My implements  DAO<User> {
    @Override
    public boolean create(User user) throws SQLException {
        user.setId(0);
        String sql = String.format("INSERT INTO `users`(`Login`, `Email`, `Pasword`, `FK_roles`)" +
                        " VALUES ('%s','%s','%s',%d)",
        user.getLogin(),user.getEmail(),user.getPasword(),user.getFk_roles());
        int id = executeUpdate(sql);
        if (id>0){
            user.setId(id);
            return true;
        }else
        return false;
    }



    @Override
    public boolean update(User user) throws SQLException {
        String sql = String .format(
                "UPDATE `users` SET `Login`='%s',`Email`='%s', `Pasword`='%s', " +
                        "`FK_roles`=%d WHERE ID=%d",
                user.getFk_roles(),user.getEmail(),
                user.getPasword(),user.getFk_roles(),user.getId());

        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String .format(
                "DELETE FROM`users`  WHERE ID=%d",
                user.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> list = getAll("where ID=" + id);
        return list.size()>0 ? list.get(0): null;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> list = new ArrayList<>();
        Connection connection = My_Connection_DB.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from users " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            User user = new  User(
                    rs.getInt("ID"),
                    rs.getString("Login"),
                    rs.getString("Email"),
                    rs.getString("Pasword"),
                    rs.getInt("FK_roles"));
            list.add(user);

        }
        return list;
    }
}
