package by.it.karpeichyk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by user on 18.02.2018.
 */
public class Add_Ad {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Driver.URL_DB, Driver.USER_DB, Driver.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO ads(Description,Carrying,Volume,Tariff,FK_Users) VALUES('Грузоперевозки по РБ и РФ',20,120,'1.5$ за километр',1);"
            );

            statement.executeUpdate(
                    "INSERT INTO ads(Description,Carrying,Volume,Tariff,FK_Users)VALUES('Грузоперевозки по Европе',20,120,'1.75$ за километр',1);"
            );
            statement.executeUpdate(
                    "INSERT INTO ads(Description,Carrying,Volume,Tariff,FK_Users) VALUES('Грузоперевозки по РБ ',10,80,'1.0$ за километр',1);"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
