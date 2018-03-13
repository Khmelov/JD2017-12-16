package by.it.sevashko.project.java.dao.helpers;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Publication;
import by.it.sevashko.project.java.entities.Subscription;
import by.it.sevashko.project.java.entities.User;

import java.sql.*;

public class ResetDB {

    private static Statement statement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:2016?useUnicode=true&characterEncoding=UTF-8",
                        "root",
                        ""
        );
        statement = connection.createStatement();
        deleteAll();
        createSchema();
        createRolesTable();
        createPublicationTable();
        createUsersTable();
        createSubscriptionsTable();
        addRoles();
        addUsers();
        addPublications();
        addSubscriptions();
    }

    private static void deleteAll() throws SQLException {
        statement.executeUpdate("DROP SCHEMA IF EXISTS `sevashko` ;");
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

    private static void addRoles() throws SQLException {
        statement.executeUpdate("INSERT INTO `sevashko`.`roles` (`role`) VALUES ('Админитратор');");
        statement.executeUpdate("INSERT INTO `sevashko`.`roles` (`role`) VALUES ('Подписчик');");
    }

    private static void addUsers() throws SQLException {
        User user1 = new User(0, "VladSV", "qwerty", "Владислав",
                "Севашко", "vladsvby@yandex.by",1);
        User user2 = new User(0, "Ivan48", "12345", "Иван",
                "Иванов", "afdmag@mail.by",2);
        User user3 = new User(0, "PetrBY", "12345", "Петр",
                "Петров", "afaga@google.by",2);
        DAO dao = DAO.getDAO();
        dao.userDAO.create(user1);
        dao.userDAO.create(user2);
        dao.userDAO.create(user3);
    }

    private static void addPublications() throws SQLException {
        Publication publication1 = new Publication(0, "Автодайджест", 12, 1, 3.66f);
        Publication publication2 = new Publication(0, "Транспортная безопасность", 24, 1, 13.45f);
        Publication publication3 = new Publication(0, "Транспортный вестник", 26, 1, 14.85f);
        DAO dao = DAO.getDAO();
        dao.publicationDAO.create(publication1);
        dao.publicationDAO.create(publication2);
        dao.publicationDAO.create(publication3);
    }

    private static void addSubscriptions() throws SQLException {
        Subscription subscription1 = new Subscription(0,1, 1, 2,
                4, Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 14.64f);
        Subscription subscription2 = new Subscription(0,2, 2, 1,4,
                Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 15.8f);
        Subscription subscription3 = new Subscription(0, 2, 3, 3,
                4, Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 98.34f);
        DAO dao = DAO.getDAO();
        dao.subscriptionsDAO.create(subscription1);
        dao.subscriptionsDAO.create(subscription2);
        dao.subscriptionsDAO.create(subscription3);
    }
}
