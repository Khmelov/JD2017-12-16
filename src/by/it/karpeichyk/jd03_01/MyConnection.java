package by.it.karpeichyk.jd03_01;




import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Created by user on 18.02.2018.
 */
public class MyConnection {
    public static void main(String[] args) {


        //Driver driver = new FabricMySQLDriver();
        //DriverManager.
        try (Connection connection = DriverManager.getConnection
                (Driver.URL_DB, Driver.USER_DB, Driver.PASSWORD_DB);) {

if(!connection.isClosed())
    System.out.println("Соединение установлено");
if (connection.isClosed())
    connection.close();
    System.out.println("Соединение прервано");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
