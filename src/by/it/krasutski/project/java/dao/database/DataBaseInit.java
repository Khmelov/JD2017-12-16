package by.it.krasutski.project.java.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInit {
    public static void main(String[] args) {
        initDB();
    }

    public static void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `krasutski` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `krasutski` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("USE `krasutski` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `krasutski`.`category` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krasutski`.`category` (\n" +
                    "`ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`Name` VARCHAR(45) NOT NULL,\n" +
                    "PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `krasutski`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krasutski`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `krasutski`.`users` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krasutski`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `NickName` VARCHAR(45) NULL,\n" +
                    "  `PhoneNumber` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `krasutski`.`roles` (`ID`))\n" +
                    "ENGINE = InnoDB\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `krasutski`.`ads` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krasutski`.`ads` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Title` VARCHAR (45) NOT NULL,\n" +
                    "  `SmallDesc` VARCHAR(45) NOT NULL,\n" +
                    "  `Description` VARCHAR(45) NOT NULL,\n" +
                    "  `Price` INT NOT NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  `category_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_ID` ASC),\n" +
                    "  INDEX `fk_ads_category1_idx` (`category_ID` ASC),\n" +
                    "  CONSTRAINT `fk_ads_category1`\n" +
                    "    FOREIGN KEY (`category_ID`)\n" +
                    "    REFERENCES `krasutski`.`category` (`ID`),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `krasutski`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("INSERT INTO `krasutski`.`roles` (`Role`) VALUES ('Administrator');");
            statement.executeUpdate("INSERT INTO `krasutski`.`roles` (`Role`) VALUES ('User');");

            statement.executeUpdate("INSERT INTO `krasutski`.`users` (`Login`, `Password`, `Email`, `Nickname`, `PhoneNumber`, `roles_ID`) VALUES ('admin', 'admin', 'admin@it.by', 'Administrator', 'Secret', 1);");
            statement.executeUpdate("INSERT INTO `krasutski`.`users` (`Login`, `Password`, `Email`, `Nickname`, `PhoneNumber`, `roles_ID`) VALUES ('george123', 'george123', 'george@it.by', 'George', '+375447698698', 2);");

            statement.executeUpdate("INSERT INTO `krasutski`.`category` (`Name`) VALUES ('Smartphone'); ");
            statement.executeUpdate("INSERT INTO `krasutski`.`category` (`Name`) VALUES ('Laptop');");
            statement.executeUpdate("INSERT INTO `krasutski`.`category` (`Name`) VALUES ('TV');");
            statement.executeUpdate("INSERT INTO `krasutski`.`category` (`Name`) VALUES ('Game Console');");
            statement.executeUpdate("INSERT INTO `krasutski`.`category` (`Name`) VALUES ('Games');");

            statement.executeUpdate("INSERT INTO `krasutski`.`ads` (`Title`, `SmallDesc`, `Description`,`Price`, `users_ID`,`category_ID`) VALUES ('iPhone X Space Grey', '64gb', '10/10 good phone', 999, 2, 1);");
            statement.executeUpdate("INSERT INTO `krasutski`.`ads` (`Title`, `SmallDesc`, `Description`,`Price`, `users_ID`,`category_ID`) VALUES ('Samsung UE43MU61100U', '43 inches 4kUHD', 'New TV by Samsung, Smart TV', 500, 2, 3);");
            statement.executeUpdate("INSERT INTO `krasutski`.`ads` (`Title`, `SmallDesc`, `Description`,`Price`, `users_ID`,`category_ID`) VALUES ('Macbook pro', '2013-mid', 'Used 8/10 good laptop', 799, 2, 2);");

            System.out.println("Database initialized");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
