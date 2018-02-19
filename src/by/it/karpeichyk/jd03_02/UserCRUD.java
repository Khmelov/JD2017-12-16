package by.it.karpeichyk.jd03_02;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 19.02.2018.
 */

public class UserCRUD implements BeanCRUD<User> {


    @Override
    public boolean update(User user) throws SQLException {
        try (Connection cnc = My_Connection_DB.getConnection();
             Statement statement = cnc.createStatement()){
            String sql = String.format("UPDATE `users` SET `Login`='%s',`Email`='%s', `Password`='%s', " +
                    "`FK_roles`=%d WHERE ID=%d",user.getLogin(),user.getEmail(),
                    user.getPasword(),user.getFk_roles(), user.getId());
            int recCount = statement.executeUpdate(sql);
            return recCount == 1;
        }
    }

    @Override
   public boolean create(User user) throws SQLException {
        user.setId(0);
       try(Connection cnc = My_Connection_DB.getConnection();
       Statement statement = cnc.createStatement()){
           String sql = String.format("INSERT INTO `users`(`Login`, `Email`, `Pasword`, `FK_roles`)" +
                   " VALUES ('%s','%s','%s',%d)",
                 user.getLogin(),user.getEmail(),user.getPasword(),user.getFk_roles());
           int recCount = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
           if(recCount==1){
               ResultSet keys = statement.getGeneratedKeys();
               if(keys.next()){
                   int id= keys.getInt(1);
                   user.setId(id);
               }
           }
           return recCount==1;
       }
   }

    @Override
    public boolean delete(User user) throws SQLException {
        try(Connection cnc = My_Connection_DB.getConnection();
            Statement statement = cnc.createStatement()){
            String sql = String.format("DELETE FROM `users` WHERE ID=%d",user.getId());
            int recCount= statement.executeUpdate(sql);
        return recCount == 1;
    }}

    @Override
    public User read(int id) throws SQLException {
        try(Connection cnc = My_Connection_DB.getConnection();
            Statement statement = cnc.createStatement()){
            String sql = String.format("SELECT *  FROM `users` WHERE ID=%d",id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return  new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email"),
                        resultSet.getString("Pasword"),
                        resultSet.getInt("FK_roles"));

            }
        }
        return null;
    }
}
