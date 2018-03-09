package by.it.sevashko.jd03_03;

import by.it.sevashko.jd03_03.beans.Publication;
import by.it.sevashko.jd03_03.beans.Role;
import by.it.sevashko.jd03_03.beans.Subscription;
import by.it.sevashko.jd03_03.beans.User;
import by.it.sevashko.jd03_03.helpers.B_AddRoles;
import by.it.sevashko.jd03_03.helpers.Cleaner;
import by.it.sevashko.jd03_03.helpers.DBCreation;

import java.sql.Date;
import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        Cleaner.dropAll();
        DBCreation.createDataBase();
        B_AddRoles.addRoles();

        DAO dao = DAO.getDAO();

        //создание пользователей
        User user1 = new User(0, "VladSV", "12345", "Владос",
                "Севашко", "vladsvby@yandex.by",1);
        User user2 = new User(0, "Ivan48", "12345", "Иван",
                "Иванов", "afdmag@mail.by",2);
        User user3 = new User(0, "PetrBY", "12345", "Петр",
                "Петров", "afaga@google.by",2);
        dao.userDAO.create(user1);
        dao.userDAO.create(user2);
        dao.userDAO.create(user3);
        System.out.println("Создан " + user1);
        System.out.println("Создан " + user2);
        System.out.println("Создан " + user3);

        //publications
        Publication publication1 = new Publication(0, "Автодайджест", 12, 1, 3.66f);
        Publication publication2 = new Publication(0, "Транспортная безопасность", 24, 1, 13.45f);
        Publication publication3 = new Publication(0, "Транспортный вестник", 26, 1, 14.85f);
        dao.publicationDAO.create(publication1);
        dao.publicationDAO.create(publication2);
        dao.publicationDAO.create(publication3);
        System.out.println("Создан " + publication1);
        System.out.println("Создан " + publication2);
        System.out.println("Создан " + publication3);

        //subscriptions
        Subscription subscription1 = new Subscription(0,2, 1, 2,
                4, Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 14.64f);
        Subscription subscription2 = new Subscription(0,2, 2, 1,4,
                Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 15.8f);
        Subscription subscription3 = new Subscription(0, 2, 3, 3,
                4, Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 98.34f);
        dao.subscriptionsDAO.create(subscription1);
        dao.subscriptionsDAO.create(subscription2);
        dao.subscriptionsDAO.create(subscription3);

        System.out.println("--------------------------------------\nВсе роли");
        for (Role role : dao.roleDAO.getALL("")) System.out.println(role);

        System.out.println("--------------------------------------\nВсе пользователи");
        for (User user : dao.userDAO.getALL("")) System.out.println(user);

        System.out.println("--------------------------------------\nВсе издания");
        for (Publication publication : dao.publicationDAO.getALL("")) System.out.println(publication);

        System.out.println("--------------------------------------\nВсе подписки");
        for (Subscription subscription : dao.subscriptionsDAO.getALL("")) System.out.println(subscription);
        System.out.println("--------------------------------------\nЧтение");

        //чтение
        System.out.println("Прочтено " + dao.roleDAO.read(1));
        System.out.println("Прочтено " + dao.userDAO.read(1));
        System.out.println("Прочтено " + dao.publicationDAO.read(1));
        System.out.println("Прочтено " + dao.subscriptionsDAO.read(1));
        System.out.println("--------------------------------------\nИзменение");

        user1.setName("Владислав");
        publication1.setName("Tru-tu-tu");
        subscription1.setPrice(12.47f);
        dao.userDAO.update(user1);
        dao.subscriptionsDAO.update(subscription1);
        dao.publicationDAO.update(publication1);
        System.out.println("Изменено имя " + dao.userDAO.read(1));
        System.out.println("Изменено название " + dao.publicationDAO.read(1));
        System.out.println("Изменена цена " + dao.subscriptionsDAO.read(1));

        System.out.println("--------------------------------------\nУдаление");
        if (dao.userDAO.delete(user1)) System.out.println("Удалено " + user1);
        if (dao.subscriptionsDAO.delete(subscription1)) System.out.println("Удалено " + subscription1);
        if (dao.publicationDAO.delete(publication1)) System.out.println("Удалено " + publication1);

        System.out.println("--------------------------------------\nВсе роли");
        for (Role role : dao.roleDAO.getALL("")) System.out.println(role);

        System.out.println("--------------------------------------\nВсе пользователи");
        for (User user : dao.userDAO.getALL("")) System.out.println(user);

        System.out.println("--------------------------------------\nВсе издания");
        for (Publication publication : dao.publicationDAO.getALL("")) System.out.println(publication);

        System.out.println("--------------------------------------\nВсе подписки");
        for (Subscription subscription : dao.subscriptionsDAO.getALL("")) System.out.println(subscription);
    }
}
