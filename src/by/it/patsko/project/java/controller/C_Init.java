package by.it.patsko.project.java.controller;


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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016"
                        + "?useUnicode=true&characterEncoding=UTF-8",
                "root", ""
        );
             Statement statement = connection.createStatement()
        ) {


            statement.executeUpdate("DROP SCHEMA IF EXISTS `patsko` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `patsko` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patsko`.`Roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Buyers` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patsko`.`Buyers` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL," +
                    "  `Roles_id` INT NOT NULL DEFAULT 2," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_Buyers_Roles1_idx` (`Roles_id` ASC)," +
                    "  CONSTRAINT `fk_Buyers_Roles1`" +
                    "    FOREIGN KEY (`Roles_id`)" +
                    "    REFERENCES `patsko`.`Roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Catalog` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patsko`.`Catalog` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `catalogName` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Category` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patsko`.`Category` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `CategoryName` VARCHAR(100) NULL,\n" +
                    "  `Catalog_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Category_Catalog2_idx` (`Catalog_id` ASC),\n" +
                    "  CONSTRAINT `fk_Category_Catalog2`\n" +
                    "    FOREIGN KEY (`Catalog_id`)\n" +
                    "    REFERENCES `patsko`.`Catalog` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`Books` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patsko`.`Books` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(200) NULL,\n" +
                    "  `author` VARCHAR(200) NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `Category_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Books_Category1_idx` (`Category_id` ASC),\n" +
                    "  CONSTRAINT `fk_Books_Category1`\n" +
                    "    FOREIGN KEY (`Category_id`)\n" +
                    "    REFERENCES `patsko`.`Category` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `patsko`.`List of purchases` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patsko`.`List of purchases` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Buyers_id` INT NOT NULL,\n" +
                    "  `Books_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_List of purchases_Buyers2_idx` (`Buyers_id` ASC),\n" +
                    "  INDEX `fk_List of purchases_Books1_idx` (`Books_id` ASC),\n" +
                    "  CONSTRAINT `fk_List of purchases_Buyers2`\n" +
                    "    FOREIGN KEY (`Buyers_id`)\n" +
                    "    REFERENCES `patsko`.`Buyers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_List of purchases_Books1`\n" +
                    "    FOREIGN KEY (`Books_id`)\n" +
                    "    REFERENCES `patsko`.`Books` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `patsko`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `patsko`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'buyer');");
            statement.executeUpdate("INSERT INTO `patsko`.`Buyers` (`id`, `login`, `password`, `email`, `Roles_id`) " +
                    "VALUES (DEFAULT, 'admin', 'password', 'admin@admin.by', 1);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Buyers` (`id`, `login`, `password`, `email`, `Roles_id`) " +
                    "VALUES (DEFAULT, 'buyer1', 'qwerty', 'buyer1@buyer.by', 2);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Buyers` (`id`, `login`, `password`, `email`, `Roles_id`) " +
                    "VALUES (DEFAULT, 'buyer2', '12345', 'buyer2@buyer.by', 2);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Catalog` (`id`, `catalogName`) VALUES (DEFAULT, 'Каталог книг');");
            statement.executeUpdate("INSERT INTO `patsko`.`Category` (`id`, `CategoryName`, `Catalog_id`) " +
                    "VALUES (DEFAULT, 'CS', 1);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Category` (`id`, `CategoryName`, `Catalog_id`) " +
                    "VALUES (DEFAULT, 'Fiction', 1);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) " +
                    "VALUES (DEFAULT, 'Java. Эффективное программирование', 'Джошуа Блох', 200, 1);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) " +
                    "VALUES (DEFAULT, 'Java 8. Полное руководство', 'Герберт Шилдт', 500, 1);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) " +
                    "VALUES (DEFAULT, 'Оно', 'Стивен Кинг', 100, 2);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`List of purchases` (`id`, `Buyers_id`, `Books_id`) " +
                    "VALUES (DEFAULT, 1, 1);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`List of purchases` (`id`, `Buyers_id`, `Books_id`) " +
                    "VALUES (DEFAULT, 1, 3);\n");
            statement.executeUpdate("INSERT INTO `patsko`.`List of purchases` (`id`, `Buyers_id`, `Books_id`) " +
                    "VALUES (DEFAULT, 2, 2);\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
