package by.it.karpeichyk.Project.java.dao.ConnectWithDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 19.02.2018.
 */
public class My_Connection_DB {
    private  static final  String URL_DB = "jdbc:mysql://127.0.0.1:2016/karpeychik?useUnicode=true&characterEncoding=UTF-8";

    private  static final  String USER_DB= "root";
    private  static final  String PASSWORD_DB="";
    private  static Connection connection;



    public  static Connection getConnection (){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            if (connection==null||connection.isClosed())
                connection = DriverManager.getConnection(URL_DB,USER_DB,PASSWORD_DB);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  connection;
    }
}
