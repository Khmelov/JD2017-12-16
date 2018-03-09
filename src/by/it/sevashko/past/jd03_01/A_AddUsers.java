package by.it.sevashko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUsers {

    static void addUsers(){
            try (
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:2016?useUnicode=true&characterEncoding=UTF-8",
                            "root",
                            ""
                    )) {
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO `sevashko`.`users` "
                        + "(`login`, `password`, `name`, `lastName`, `email`, `fk_role`) VALUES "
                        +"('VladSV', 'qwerty1234', 'Владислав', 'Севашко', 'vladsvby@yandex.by', '1');");
                statement.executeUpdate("INSERT INTO `sevashko`.`users` "
                        + "(`login`, `password`, `name`, `lastName`, `email`, `fk_role`) VALUES "
                        +"('Ivan96', '1994ivan', 'Иван', 'Иванов', 'ivan96@mail.ru', '2');");
                statement.executeUpdate("INSERT INTO `sevashko`.`users` "
                        + "(`login`, `password`, `name`, `lastName`, `email`, `fk_role`) VALUES "
                        +"('PavelPON', 'oakf15', 'Павел', 'Борисенко', 'boris894@mail.ru', '2');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
