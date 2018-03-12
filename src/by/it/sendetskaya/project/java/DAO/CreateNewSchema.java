package by.it.sendetskaya.project.java.DAO;

import by.it.sendetskaya.project.java.DAO.connect.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Locale;

public class CreateNewSchema {

    public static final String URL_DB="jdbc:mysql://127.0.0.1:2016"+
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        deleteSchema();
        createSchema();
        fillDataRoles();
        fillData();
    }

        public static boolean deleteSchema ()  throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = null;
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
                (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            String sql=String.format("DROP SCHEMA IF EXISTS `sendetskaya`;");

            return (statement.executeUpdate(sql)==1);
        }
    }

    public static void createSchema ()  throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = null;
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
             Statement statement = connection.createStatement()) {

            String sql=String.format("CREATE SCHEMA IF NOT EXISTS `sendetskaya` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate(sql);

            sql=String.format("DROP TABLE IF EXISTS `sendetskaya`.`roles` ;");
            statement.executeUpdate(sql);

            sql=String.format("CREATE TABLE IF NOT EXISTS `sendetskaya`.`roles` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate(sql);

            sql=String.format("DROP TABLE IF EXISTS `sendetskaya`.`buyers` ;");
            statement.executeUpdate(sql);

            sql=String.format("CREATE TABLE IF NOT EXISTS `sendetskaya`.`buyers` (\n" +
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
            statement.executeUpdate(sql);

            sql=String.format("DROP TABLE IF EXISTS `sendetskaya`.`goods` ;");
            statement.executeUpdate(sql);

            sql=String.format("CREATE TABLE IF NOT EXISTS `sendetskaya`.`goods` (\n" +
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
            statement.executeUpdate(sql);

            sql=String.format("DROP TABLE IF EXISTS `sendetskaya`.`baskets`;");
            statement.executeUpdate(sql);

            sql=String.format("CREATE TABLE IF NOT EXISTS `sendetskaya`.`baskets` (\n" +
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
                    "    REFERENCES `sendetskaya`.`goods` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate(sql);
        }
    }

    public static void fillDataRoles ()  throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = null;
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
             Statement statement = connection.createStatement()) {
            String sql=String.format("INSERT INTO sendetskaya.roles (Role) VALUES ('Администратор');");
            statement.executeUpdate(sql);

           sql=String.format("INSERT INTO sendetskaya.roles (Role) VALUES ('Пользователь');");
            statement.executeUpdate(sql);
        }
    }

    public static void fillData ()  throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = null;
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
             Statement statement = connection.createStatement()) {
            String sql=String.format(Locale.US,"INSERT INTO sendetskaya.buyers(Email, Nickname, Password, FK_roles) " +
                    "VALUES ('admin@admin.ru','admin','admin',1);");
            statement.executeUpdate(sql);

            sql=String.format(Locale.US,"INSERT INTO sendetskaya.goods (Name, Price, Size, Colour, Structure, Description)" +
                    " VALUES ('кофта',2.30,'s','красный','хлопок','Отменная кофта');");
            statement.executeUpdate(sql);

            sql=String.format(Locale.US,"INSERT INTO sendetskaya.goods (Name, Price, Size, Colour, Structure, Description)" +
                    " VALUES ('майка',5.70,'m','черный','велюр','майка с улыбкой');");
            statement.executeUpdate(sql);

            sql=String.format(Locale.US,"INSERT INTO sendetskaya.goods (Name, Price, Size, Colour, Structure, Description)" +
                    " VALUES ('шляпа',1.65,'s','зеленый','соломенная','Шляпа с лентой');");
            statement.executeUpdate(sql);


            sql=String.format(Locale.US,"INSERT INTO sendetskaya.baskets (Quantity, Sum, FK_buyers, FK_goods) " +
                    "VALUES (2,4.60,1,1);");
            statement.executeUpdate(sql);
        }
    }
}
