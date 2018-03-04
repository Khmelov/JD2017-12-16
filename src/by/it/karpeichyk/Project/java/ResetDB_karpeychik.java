package by.it.karpeichyk.Project.java;



import by.it.karpeichyk.Project.java.dao.ConnectWithDB.My_Connection_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 02.03.2018.
 */
public class ResetDB_karpeychik {
    private  static  final  String URL_DB =
            "jdbc:mysql://127.0.0.1:2016"
                    + "?useUnicode=true&characterEncoding=UTF-8";

    private  static final String USER_DB = "root";
    private  static final String PASSWORD_DB = "";

    public static void main(String[] args)  throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =  DriverManager.getConnection(URL_DB,USER_DB,PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP SCHEMA IF EXISTS `karpeychik`");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `karpeychik` DEFAULT CHARACTER SET utf8");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karpeychik`.`roles` (\n" +
                "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `ROLE` VARCHAR(50) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`))\n" +
                "ENGINE = InnoDB\n" +
                "AUTO_INCREMENT = 3\n" +
                "DEFAULT CHARACTER SET = utf8;\n");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karpeychik`.`users` (\n" +
                "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `Login` VARCHAR(50) NOT NULL,\n" +
                "  `Pasword` VARCHAR(50) NOT NULL,\n" +
                "  `Email` VARCHAR(50) NOT NULL,\n" +
                "  `FK_roles` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`),\n" +
                "  INDEX `fk_users_roles_idx` (`FK_roles` ASC),\n" +
                "  CONSTRAINT `fk_users_roles`\n" +
                "    FOREIGN KEY (`FK_roles`)\n" +
                "    REFERENCES `karpeychik`.`roles` (`ID`))\n" +
                "ENGINE = InnoDB\n" +
                "AUTO_INCREMENT = 3\n" +
                "DEFAULT CHARACTER SET = utf8;\n");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karpeychik`.`ads` (\n" +
                "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `Description` VARCHAR(50) NOT NULL,\n" +
                "  `Carrying` INT(11) NOT NULL,\n" +
                "  `Volume` INT(11) NOT NULL,\n" +
                "  `Tariff` VARCHAR(50) NOT NULL,\n" +
                "  `FK_Users` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`),\n" +
                "  INDEX `fk_ads_users1_idx` (`FK_Users` ASC),\n" +
                "  CONSTRAINT `fk_ads_users1`\n" +
                "    FOREIGN KEY (`FK_Users`)\n" +
                "    REFERENCES `karpeychik`.`users` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "AUTO_INCREMENT = 6\n" +
                "DEFAULT CHARACTER SET = utf8;\n");
        statement.executeUpdate("INSERT INTO `karpeychik`.`roles` (`ID`, `ROLE`) VALUES (1, 'admin');");
        statement.executeUpdate("INSERT INTO `karpeychik`.`roles` (`ID`, `ROLE`) VALUES (2, 'user');");
        statement.executeUpdate("INSERT INTO `karpeychik`.`roles` (`ID`, `ROLE`) VALUES (3, 'guest');");
        statement.executeUpdate("INSERT INTO `karpeychik`.`users` (`ID`, `Login`, `Pasword`, `Email`, `FK_roles`) VALUES (1, 'duser', 'tutnv54', 'dgfyr@tut.ss', 1);");
        statement.executeUpdate("INSERT INTO `karpeychik`.`users` (`ID`, `Login`, `Pasword`, `Email`, `FK_roles`) VALUES (DEFAULT, 'truckdriver', 'tytuy66', 'dgs@tut.su', 2);");
        statement.executeUpdate("INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Carrying`, `Volume`, `Tariff`, `FK_Users`) VALUES (1, 'Грузперевозки РФ и РБ', 20, 120, '1,5 $ за километр', 1);");
        statement.executeUpdate("INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Carrying`, `Volume`, `Tariff`, `FK_Users`) VALUES (DEFAULT, 'Грузоперевозки по Европе', 20, 120, '1,75 $ за километр', 1);");



    }
}
