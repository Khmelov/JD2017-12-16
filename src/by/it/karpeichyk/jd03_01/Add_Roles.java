package by.it.karpeichyk.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by user on 19.02.2018.
 */
public class Add_Roles {
    public static void main(String[] args) {
        try(Connection connection=
                    DriverManager.getConnection
                            (Driver.URL_DB,Driver.USER_DB,Driver.PASSWORD_DB);
            Statement statement= connection.createStatement()){
            statement.executeUpdate("INSERT INTO roles(ROLE) VALUES('Guest');");
    }catch (Exception e){
                e.printStackTrace();
        }


}}
