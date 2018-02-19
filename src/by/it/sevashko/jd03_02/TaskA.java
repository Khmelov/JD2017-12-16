package by.it.sevashko.jd03_02;

import by.it.sevashko.jd03_02.Helpers.Cleaner;
import by.it.sevashko.jd03_02.Helpers.Connector;
import by.it.sevashko.jd03_02.Helpers.DBCreation;
import by.it.sevashko.jd03_02.beans.User;
import by.it.sevashko.jd03_02.crud.UserCRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {

    public static void main(String[] args) throws SQLException {
        Cleaner.dropAll();
        DBCreation.createDataBase();

        B_AddRoles.addRoles();  //из jd03_01

        //id по имени роли
        System.out.println("Id роли \"Подписчик\": " + findId("Подписчик"));
        System.out.println("Id роли \"Администратор\": " + findId("Админитратор"));
        System.out.println("--------------------------------------\nСоздание и чтение пользователей");

        UserCRUD userCRUD = new UserCRUD();
        //создание пользователей
        User user1 = new User(0, "VladSV", "12345", "Владос",
                "Севашко", "vladsvby@yandex.by",1);
        User user2 = new User(0, "Ivan48", "12345", "Иван",
                "Иванов", "afdmag@mail.by",2);
        User user3 = new User(0, "PetrBY", "12345", "Петр",
                "Петров", "afaga@google.by",2);
        userCRUD.create(user1);
        userCRUD.create(user2);
        userCRUD.create(user3);

        //чтение
        System.out.println(userCRUD.read(1));
        System.out.println(userCRUD.read(2));
        System.out.println(userCRUD.read(3));
        System.out.println("--------------------------------------\nИзменение пароля");

        //изменение
        user1.setPassword("qwerty");
        user1.setName("Владислав");
        userCRUD.update(user1);
        System.out.println(userCRUD.read(1));
        System.out.println("--------------------------------------\nУдаление");

        //удаление
        if (userCRUD.delete(user2)) System.out.println(user2 +" успешно удален");
        else System.out.println(user2 + " удалить не удалось");
    }

    private static int findId(String name){
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM roles WHERE role='%s'", name));
            if (resultSet.next()) return resultSet.getInt(1);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
