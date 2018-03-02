package by.it.viktorbrui.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD implements BeanCRUD<User> {


    @Override
    public boolean create(User user) throws SQLException {
        user.setId(0);
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `user`(`nickname`, `email`, `password`, `address`, `phone`, `FK_Roles`)" +
                            " VALUES ('%s','%s','%s','%s',%d,%d)",
                    user.getNickname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getFK_Roles());
            int recCount = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
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
    public boolean update(User user) throws SQLException {
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `user` SET `nickname`='%s',`email`='%s', `password`='%s', `address`='%s', `phone`='%d', " +
                            "`FK_Roles`=%d WHERE ID=%d",
                    user.getNickname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(),
                    user.getFK_Roles(), user.getId());
            int recCount = statement.executeUpdate(sql);
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(User user) throws SQLException {
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `user` WHERE ID=%d",
                    user.getId());
            int recCount = statement.executeUpdate(sql);
            return recCount == 1;
        }
    }

    @Override
    public User read(int id) throws SQLException {
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            String sql = String.format("SELECT *  FROM `user` WHERE ID=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nickname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("address"),
                        resultSet.getInt("phone"),
                        resultSet.getInt("FK_Roles")

                );
            }
        }
        return null;
    }


}
