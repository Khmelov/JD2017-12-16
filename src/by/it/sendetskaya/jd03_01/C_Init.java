package by.it.sendetskaya.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Init {
    public static final String URL_DB="jdbc:mysql://127.0.0.1:2016"+
            "?useUnicode=true&characterEncoding=UTF-8";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver= null;
            try {
                driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try (Connection connection = DriverManager.getConnection
                (URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()){

            statement.executeUpdate("DROP SCHEMA IF EXISTS `sendetskaya`;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `sendetskaya` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `sendetskaya`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sendetskaya`.`roles` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `sendetskaya`.`buyers` ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sendetskaya`.`buyers` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Email` VARCHAR(50) NOT NULL,\n" +
                    "  `Nickname` VARCHAR(50) NOT NULL,\n" +
                    "  `Password` VARCHAR(50) NOT NULL,\n" +
                    "  `FK_roles` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `FK_roles` (`FK_roles` ASC),\n" +
                    "  CONSTRAINT `buyers_ibfk_1`\n" +
                    "    FOREIGN KEY (`FK_roles`)\n" +
                    "    REFERENCES `sendetskaya`.`roles` (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `sendetskaya`.`goods` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sendetskaya`.`goods` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(50) NOT NULL,\n" +
                    "  `Price` DOUBLE NOT NULL,\n" +
                    "  `Size` VARCHAR(50) NOT NULL,\n" +
                    "  `Colour` VARCHAR(50) NOT NULL,\n" +
                    "  `Structure` VARCHAR(50) NOT NULL,\n" +
                    "  `Description` VARCHAR(200) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `sendetskaya`.`baskets`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sendetskaya`.`baskets` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Quantity` INT(11) NOT NULL,\n" +
                    "  `Sum` DOUBLE NOT NULL,\n" +
                    "  `FK_buyers` INT(11) NOT NULL,\n" +
                    "  `FK_goods` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `FK_goods` (`FK_goods` ASC),\n" +
                    "  INDEX `baskets_ibfk_1` (`FK_buyers` ASC),\n" +
                    "  CONSTRAINT `baskets_ibfk_1`\n" +
                    "    FOREIGN KEY (`FK_buyers`)\n" +
                    "    REFERENCES `sendetskaya`.`buyers` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `baskets_ibfk_2`\n" +
                    "    FOREIGN KEY (`FK_goods`)\n" +
                    "    REFERENCES `sendetskaya`.`goods` (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("INSERT INTO sendetskaya.roles (Role) VALUES ('Администратор');");
            statement.executeUpdate("INSERT INTO sendetskaya.roles (Role) VALUES ('Пользователь');");
            statement.executeUpdate("INSERT INTO sendetskaya.buyers(Email, Nickname, Password, FK_roles) " +
                    "VALUES ('qwe@qwe.ru','qwe','qweqwe',1);");
            statement.executeUpdate("INSERT INTO sendetskaya.goods (Name, Price, Size, Colour, Structure, Description)" +
                    " VALUES ('кофта',2.30,'s','красный','хлопок','Отменная кофта');");
            statement.executeUpdate("INSERT INTO sendetskaya.baskets (Quantity, Sum, FK_buyers, FK_goods) " +
                    "VALUES (2,4.60,1,1);");

            if ((!connection.isClosed()))
                System.out.println("Соединение установлено");
            connection.close();
            if (connection.isClosed())
                System.out.println("Соединение прервано");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
