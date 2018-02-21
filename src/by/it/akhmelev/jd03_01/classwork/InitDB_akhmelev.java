package by.it.akhmelev.jd03_01.classwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB_akhmelev {

    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016"
                    + "?useUnicode=true&characterEncoding=UTF-8";

    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP SCHEMA IF EXISTS `akhmelev`");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` ( `ID` INT(11) NOT NULL AUTO_INCREMENT,        `role` VARCHAR(50) NOT NULL,        PRIMARY KEY (`ID`))        ENGINE = InnoDB        DEFAULT CHARACTER SET = utf8;"
        );
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (\n" +
                "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `Login` VARCHAR(50) NOT NULL,\n" +
                "  `Email` VARCHAR(50) NOT NULL,\n" +
                "  `Password` VARCHAR(50) NOT NULL,\n" +
                "  `FK_roles` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`),\n" +
                "  INDEX `fk_users_roles1_idx` (`FK_roles` ASC),\n" +
                "  CONSTRAINT `fk_users_roles1`\n" +
                "    FOREIGN KEY (`FK_roles`)\n" +
                "    REFERENCES `akhmelev`.`roles` (`ID`)\n" +
                "    ON DELETE RESTRICT\n" +
                "    ON UPDATE RESTRICT)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (\n" +
                "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `Description` VARCHAR(2000) NOT NULL,\n" +
                "  `Address` VARCHAR(300) NOT NULL,\n" +
                "  `Floor` INT(11) NOT NULL,\n" +
                "  `Floors` INT(11) NOT NULL,\n" +
                "  `RoomCount` INT(11) NOT NULL,\n" +
                "  `Price` DOUBLE NOT NULL,\n" +
                "  `Area` DOUBLE NOT NULL,\n" +
                "  `FK_users` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`),\n" +
                "  INDEX `fk_ads_users1_idx` (`FK_users` ASC),\n" +
                "  CONSTRAINT `fk_ads_users1`\n" +
                "    FOREIGN KEY (`FK_users`)\n" +
                "    REFERENCES `akhmelev`.`users` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");
        statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administrator');\n");
        statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'User');");
        statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Guest');");
        statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Email`, `Password`, `FK_roles`) VALUES (DEFAULT, 'admin', 'admin@it.by', 'admin', 1);");
        statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Email`, `Password`, `FK_roles`) VALUES (DEFAULT, 'user', 'user@it.by', 'user', 2);");
        statement.executeUpdate("INSERT INTO `akhmelev`.`ads` (`ID`, `Description`, `Address`, `Floor`, `Floors`, `RoomCount`, `Price`, `Area`, `FK_users`) VALUES (DEFAULT, 'Good price', 'Lenina 1', 1, 1, 1, 111111, 111, 2);");

    }

}
