package by.it.sendetskaya.jd03_03;

import by.it.sendetskaya.jd03_03.bean.Buyer;
import by.it.sendetskaya.jd03_03.bean.Good;
import by.it.sendetskaya.jd03_03.bean.Role;

import java.sql.SQLException;

public class Runner {
    private static DAO dao;

    public static void main(String[] args) throws SQLException {

        CreateNewSchema.deleteSchema();
        CreateNewSchema.createSchema();
        CreateNewSchema.fillDataRoles();
        CreateNewSchema.fillData();

        dao=DAO.getDAO();
        System.out.println("===================================");
        showRoles(dao);

        System.out.println("===================================");

        SelectRequest.selectUser();
        System.out.println("===================================");

        Good good=new Good(0,"кофта",2.30,"s",
                "красный","хлопок","Отменная кофта");
        System.out.println("-----------All--------------");
        System.out.println(dao.goodDAO.getAll());
        System.out.println("===================================");

        dao.goodDAO.create(good);
        System.out.println("-------- Create ------------");
        System.out.println(dao.goodDAO.getAll());
        System.out.println("===================================");

        good.setColour("!!!!");
        dao.goodDAO.update(good);
        System.out.println("-------- Update ------------");
        System.out.println(dao.goodDAO.getAll());
        System.out.println("===================================");

        dao.goodDAO.delete(good);
        System.out.println("-------- Delete ------------");
        System.out.println(dao.goodDAO.getAll());
        System.out.println("===================================");

        Buyer buyer = new Buyer(0,"qwe@qwe.ru","qwe","qweqwe",2);
        //добавим пользователя
        if (dao.buyerDAO.create(buyer))
            System.out.println("\nДобавлен:" + buyer);
        showBuyers(dao);
        System.out.println("===================================");

        //извлечем и обновим пользователя
        buyer = dao.buyerDAO.getAll("WHERE ID>2").get(0);
        buyer.setNickname("up_siivanov");
        if (dao.buyerDAO.update(buyer))
            System.out.println("\nИзменен:" + buyer);
        showBuyers(dao);
        System.out.println("===================================");

        //удалим пользователя
        if (dao.buyerDAO.delete(buyer))
            System.out.println("\nУдален:" + buyer);
        showBuyers(dao);
        System.out.println("===================================");
    }

    //показать все роли
    static void showRoles(DAO dao) throws SQLException {

        System.out.println("Роли пользователей");
        for (Role role: dao.roleDAO.getAll()) {
            System.out.println(role);
        }
    }

    //показать всех пользователей
    static void showBuyers(DAO dao) throws SQLException {

        System.out.println("\nТаблица пользователей:");
        for (Buyer buyer: dao.buyerDAO.getAll()) {
            System.out.println(buyer);
        }
    }
}
