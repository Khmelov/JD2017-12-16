package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.Helpers.Connector;
import by.it.sevashko.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD implements CRUD<User>{

    @Override
    public boolean create(User user) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `users` (`login`, `password`, `name`, `lastName`, `email`, `fk_role`) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s', '%d');",
                    user.getLogin(),user.getPassword(),user.getName(),user.getLastName(),user.getEmail(),user.getFk_role());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    user.setId(id);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public User read(int id) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `users` WHERE id=%d;", id);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
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
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String set = String.format("UPDATE `users` SET login='%s', password='%s', name='%s', lastName='%s'," +
                            "email='%s', fk_role='%d' WHERE users.id='%d';",
                    user.getLogin(),user.getPassword(),user.getName(),
                    user.getLastName(),user.getEmail(),user.getFk_role(), user.getId());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(User user) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM users WHERE id=%d;", user.getId());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
