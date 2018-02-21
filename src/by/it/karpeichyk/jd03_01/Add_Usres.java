package by.it.karpeichyk.jd03_01;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by user on 18.02.2018.
 */
public class Add_Usres {
    public static void main(String[] args) {
      try( Connection connection=
                   DriverManager.getConnection
                           (Driver.URL_DB,Driver.USER_DB,Driver.PASSWORD_DB);
        Statement statement= connection.createStatement()){
            statement.executeUpdate(
                    "INSERT INTO users(Login,Pasword,Email,FK_roles) VALUES('Tester','tester','poty@tut.by',1);"
            );
           statement.executeUpdate(
                  "insert into users(Login,Pasword,Email,FK_roles)"+
                           " values('ivan','driver3','lorry@tut.by',2);"
            );
      }
      catch (Exception e){
          e.printStackTrace();
      }
    }
}
