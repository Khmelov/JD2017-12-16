package by.it.kozlov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kozlov` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kozlov` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("USE `kozlov` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`brand` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`brand` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `brand` VARCHAR(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`city` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`city` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `city` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`roles` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`users` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`users` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(50) NOT NULL,\n" +
                    "  `Email` VARCHAR(50) NOT NULL,\n" +
                    "  `Password` VARCHAR(50) NOT NULL,\n" +
                    "  `city_ID` INT(11) NOT NULL,\n" +
                    "  `Address` VARCHAR(100) NOT NULL,\n" +
                    "  `PhoneNumber` VARCHAR(50) NOT NULL,\n" +
                    "  `roles_ID` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_ID` ASC),\n" +
                    "  INDEX `fk_users_city1_idx` (`city_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_city1`\n" +
                    "    FOREIGN KEY (`city_ID`)\n" +
                    "    REFERENCES `kozlov`.`city` (`ID`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `kozlov`.`roles` (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`cars` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`cars` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `brand_ID` INT(11) NOT NULL,\n" +
                    "  `Model` VARCHAR(50) NOT NULL,\n" +
                    "  `Class` VARCHAR(50) NOT NULL,\n" +
                    "  `Price` DOUBLE NOT NULL,\n" +
                    "  `Year` INT(11) NOT NULL,\n" +
                    "  `users_ID` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_cars_users1_idx` (`users_ID` ASC),\n" +
                    "  INDEX `fk_cars_brand1_idx` (`brand_ID` ASC),\n" +
                    "  CONSTRAINT `fk_cars_brand1`\n" +
                    "    FOREIGN KEY (`brand_ID`)\n" +
                    "    REFERENCES `kozlov`.`brand` (`ID`),\n" +
                    "  CONSTRAINT `fk_cars_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `kozlov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("INSERT INTO `kozlov`.`brand` (`brand`) VALUES ('BMW'); ");
            statement.executeUpdate("INSERT INTO `kozlov`.`brand` (`brand`) VALUES ('Mercedes-Benz');");

            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('Брестская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('Витебская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('Гомельская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('Гродненская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('Минская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('Могилевская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`city`) VALUES ('г. Минск');");

            statement.executeUpdate("INSERT INTO `kozlov`.`roles` (`Role`) VALUES ('admin');");
            statement.executeUpdate("INSERT INTO `kozlov`.`roles` (`Role`) VALUES ('user');");

            statement.executeUpdate("INSERT INTO `kozlov`.`users` (`Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES ('bayernkraft.by', 'bmw.service@bayernkraft.by', 'bayernkraft', 7, 'ул. Панченко, 9', '+375447730077', 2);");
            statement.executeUpdate("INSERT INTO `kozlov`.`users` (`Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES ('mercedes-benz.by', 'info@mercedes-benz.by', 'mercedes', 7, 'ул. Тимирязева, 70', '+375296039999', 2);");

            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (1, '7 series', 'Седан', 164400, 2018, 1);\n");
            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (1, 'X6', 'Кроссовер', 132000, 2018, 1);");
            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (2, 'E 200 4MATIC', 'Седан', 137706, 2018, 2);");
            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (2, 'GLS', 'Внедорожник', 164700, 2018, 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}