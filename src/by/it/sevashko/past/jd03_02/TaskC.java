package by.it.sevashko.jd03_02;

import by.it.sevashko.jd03_02.helpers.Cleaner;
import by.it.sevashko.jd03_02.helpers.DBCreation;
import by.it.sevashko.jd03_02.beans.Publication;
import by.it.sevashko.jd03_02.beans.Subscription;
import by.it.sevashko.jd03_02.beans.User;
import by.it.sevashko.jd03_02.crud.PublicationCRUD;
import by.it.sevashko.jd03_02.crud.SubscriptionCRUD;
import by.it.sevashko.jd03_02.crud.UserCRUD;

import java.sql.Date;
import java.sql.SQLException;

public class TaskC {

    public static void main(String[] args) throws SQLException {
        Cleaner.dropAll();
        DBCreation.createDataBase();

        B_AddRoles.addRoles();  //из jd03_01

        //users
        UserCRUD userCRUD = new UserCRUD();
        User user1 = new User(0, "VladSV", "12345", "Владос",
                "Севашко", "vladsvby@yandex.by",1);
        User user2 = new User(0, "Ivan48", "12345", "Иван",
                "Иванов", "afdmag@mail.by",2);
        User user3 = new User(0, "PetrBY", "12345", "Петр",
                "Петров", "afaga@google.by",2);
        userCRUD.create(user1);
        userCRUD.create(user2);
        userCRUD.create(user3);

        //publications
        Publication publication1 = new Publication(0, "Автодайджест", 12, 1, 3.66f);
        Publication publication2 = new Publication(0, "Транспортная безопасность", 24, 1, 13.45f);
        Publication publication3 = new Publication(0, "Транспортный вестник", 26, 1, 14.85f);
        PublicationCRUD publicationCRUD = new PublicationCRUD();
        publicationCRUD.create(publication1);
        publicationCRUD.create(publication2);
        publicationCRUD.create(publication3);

        //subscriptions
        Subscription subscription1 = new Subscription(0,2, 1, 2,
                4, Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 14.64f);
        Subscription subscription2 = new Subscription(0,2, 2, 1,4,
                Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 15.8f);
        Subscription subscription3 = new Subscription(0, 2, 3, 3,
                4, Date.valueOf("2018-01-01"), Date.valueOf("2018-03-30"), 98.34f);
        SubscriptionCRUD subscriptionCRUD = new SubscriptionCRUD();
        subscriptionCRUD.create(subscription1);
        subscriptionCRUD.create(subscription2);
        subscriptionCRUD.create(subscription3);
    }
}
