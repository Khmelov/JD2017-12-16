package by.it.sevashko.jd03_02.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreation {

    private static Statement statement;

    public static void createDataBase(){
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
                )) {
            statement = connection.createStatement();
            createSchema();
            createPublicationTable();
            createRolesTable();
            createUsersTable();
            createSubscriptionsTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createSchema() throws SQLException {
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `sevashko` DEFAULT CHARACTER SET utf8 ;");
    }

    private static void createPublicationTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sevashko`.`publications` (\n" +
                "  `index` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Индекс издания (ID)',\n" +
                "  `name` VARCHAR(200) NOT NULL COMMENT 'Наименование издания',\n" +
                "  `periodicity` INT(11) NOT NULL COMMENT 'Количество экземпляров в полугодии',\n" +
                "  `minPeriod` INT(11) NOT NULL COMMENT 'Минимальный подписной период (в месяцах)',\n" +
                "  `price` FLOAT NOT NULL COMMENT 'Цена за минимальный подписной период',\n" +
                "  PRIMARY KEY (`index`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COMMENT = 'Каталог изданий';");
    }

    private static void createRolesTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sevashko`.`roles` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID роли',\n" +
                "  `role` VARCHAR(30) NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `role_UNIQUE` (`role` ASC))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COMMENT = 'Роли пользователей';");
    }

    private static void createUsersTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sevashko`.`users` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `login` VARCHAR(45) NOT NULL COMMENT 'Логин',\n" +
                "  `password` VARCHAR(20) NOT NULL COMMENT 'Пароль',\n" +
                "  `name` VARCHAR(20) NOT NULL COMMENT 'Имя пользователя',\n" +
                "  `lastName` VARCHAR(20) NOT NULL COMMENT 'Фамилия пользователя',\n" +
                "  `email` VARCHAR(45) NOT NULL COMMENT 'Email',\n" +
                "  `fk_role` INT(11) NOT NULL COMMENT 'Роль пользователя',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `login_UNIQUE` (`login` ASC),\n" +
                "  INDEX `FK_roles_idx` (`fk_role` ASC),\n" +
                "  CONSTRAINT `fk_roles`\n" +
                "    FOREIGN KEY (`fk_role`)\n" +
                "    REFERENCES `sevashko`.`roles` (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COMMENT = 'Пользователи';");
    }

    private static void createSubscriptionsTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sevashko`.`subscriptions` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID подписки',\n" +
                "  `user` INT(11) NOT NULL COMMENT 'Пользователь',\n" +
                "  `publication` INT(11) NOT NULL COMMENT 'Издание',\n" +
                "  `copies` INT(11) NOT NULL DEFAULT '1' COMMENT 'Количество экземпляров',\n" +
                "  `period` INT(11) NOT NULL COMMENT 'Подписной период',\n" +
                "  `start_subscription` DATE NOT NULL COMMENT 'Начало подписного периода',\n" +
                "  `end_subscription` DATE NOT NULL COMMENT 'Конец подписного периода',\n" +
                "  `price` FLOAT NOT NULL COMMENT 'Цена подписки',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `FK_usres_idx` (`user` ASC),\n" +
                "  INDEX `FK_publications_idx` (`publication` ASC),\n" +
                "  CONSTRAINT `fk_publications`\n" +
                "    FOREIGN KEY (`publication`)\n" +
                "    REFERENCES `sevashko`.`publications` (`index`),\n" +
                "  CONSTRAINT `fk_usres`\n" +
                "    FOREIGN KEY (`user`)\n" +
                "    REFERENCES `sevashko`.`users` (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COMMENT = 'Пул подписок';");
    }
}
