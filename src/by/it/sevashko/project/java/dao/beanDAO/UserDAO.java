package by.it.sevashko.project.java.dao.beanDAO;

import by.it.sevashko.project.java.entities.User;
import by.it.sevashko.project.java.dao.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String insert = String.format("INSERT INTO `users` (`login`, `password`, `name`, `lastName`, `email`, `fk_role`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%d');",
                        user.getLogin(),user.getPassword(),user.getName(),user.getLastName(),user.getEmail(),user.getFk_role());
        int result = executeUpdate(insert);
        if (result > 0){
            user.setId(result);
            return true;
        }
        return false;
    }

    @Override
    public User read(int id) throws SQLException {
        String query = String.format("SELECT * FROM `users` WHERE id=%d;", id);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                return new User(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("lastName"),
                        result.getString("email"),
                        result.getInt("fk_role"));
            }
        }
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String set = String.format("UPDATE `users` SET login='%s', password='%s', name='%s', lastName='%s'," +
                        "email='%s', fk_role='%d' WHERE users.id='%d';",
                user.getLogin(),user.getPassword(),user.getName(),
                user.getLastName(),user.getEmail(),user.getFk_role(), user.getId());
        return executeUpdate(set) == 1;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String query = String.format("DELETE FROM users WHERE id=%d;", user.getId());
        return executeUpdate(query) == 1;
    }

    @Override
    public List<User> getALL(String where) throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        String query = String.format("SELECT * FROM users %s", where);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                User user = new User(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("lastName"),
                        result.getString("email"),
                        result.getInt("fk_role")
                );
                list.add(user);
            }
        }
        return list;
    }
}
