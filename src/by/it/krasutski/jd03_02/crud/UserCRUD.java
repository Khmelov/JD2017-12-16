package by.it.krasutski.jd03_02.crud;

import by.it.krasutski.jd03_02.database.ConnectionCreator;
import by.it.krasutski.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class UserCRUD implements BeanCRUD<User> {

    @Override
    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `users` (`Login`, `Password`, `Email`, `Nickname`, `PhoneNumber`, `roles_ID`) " +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%d');",
                    user.getLogin(),user.getPassword(),user.getEmail(),user.getNickname(),user.getPhoneNumber(),user.getRoles_ID());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int ID = keys.getInt(1);
                    user.setID(ID);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public User read(int ID) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `users` WHERE ID=%d;", ID);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new User(
                        result.getInt("ID"),
                        result.getString("Login"),
                        result.getString("Password"),
                        result.getString("Email"),
                        result.getString("Nickname"),
                        result.getString("PhoneNumber"),
                        result.getInt("roles_ID"));
            }
        }
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String set = String.format("UPDATE `users` SET Login='%s', Password='%s', Email='%s', Nickname='%s'," +
                            "PhoneNumber='%s', roles_ID='%d' WHERE users.ID='%d';",
                    user.getLogin(),user.getPassword(),user.getEmail(),user.getNickname(),
                    user.getPhoneNumber(),user.getRoles_ID(), user.getID());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM users WHERE ID=%d;", user.getID());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
