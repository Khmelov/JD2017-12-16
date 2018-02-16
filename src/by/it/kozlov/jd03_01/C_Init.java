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

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/kozlov?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
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
                    "AUTO_INCREMENT = 3\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`city` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`city` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `city` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 8\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kozlov`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kozlov`.`roles` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 3\n" +
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
                    "AUTO_INCREMENT = 5\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("INSERT INTO `kozlov`.`brand` (`ID`, `brand`) VALUES (1, 'BMW'); ");
            statement.executeUpdate("INSERT INTO `kozlov`.`brand` (`ID`, `brand`) VALUES (2, 'Mercedes-Benz');");

            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (1, 'Брестская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (2, 'Витебская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (3, 'Гомельская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (4, 'Гродненская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (5, 'Минская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (6, 'Могилевская область');");
            statement.executeUpdate("INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (7, 'г. Минск');");

            statement.executeUpdate("INSERT INTO `kozlov`.`roles` (`ID`, `Role`) VALUES (1, 'admin');");
            statement.executeUpdate("INSERT INTO `kozlov`.`roles` (`ID`, `Role`) VALUES (2, 'user');");

            statement.executeUpdate("INSERT INTO `kozlov`.`users` (`ID`, `Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES (1, 'bayernkraft.by', 'bmw.service@bayernkraft.by', 'bayernkraft', 7, 'ул. Панченко, 9', '+375447730077', 2);");
            statement.executeUpdate("INSERT INTO `kozlov`.`users` (`ID`, `Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES (2, 'mercedes-benz.by', 'info@mercedes-benz.by', 'mercedes', 7, 'ул. Тимирязева, 70', '+375296039999', 2);");

            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (1, 1, '7 series', 'Седан', 164400, 2018, 1);\n");
            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (2, 1, 'X6', 'Кроссовер', 132000, 2018, 1);");
            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (3, 2, 'E 200 4MATIC', 'Седан', 137706, 2018, 2);");
            statement.executeUpdate("INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (4, 2, 'GLS', 'Внедорожник', 164700, 2018, 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}