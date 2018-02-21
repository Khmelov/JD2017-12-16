package by.it.sendetskaya.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        CreateNewSchema.deleteSchema();
        CreateNewSchema.createSchema();
        CreateNewSchema.fillDataRoles();
        CreateNewSchema.fillData();

        TaskB.selectUser();

        Buyer_CRUD buyer_crud =new Buyer_CRUD();
        Buyer buyer= buyer_crud.read(1);
        System.out.println("read"+buyer);
        System.out.println("readAll:");
        buyer_crud.readAll();

        buyer.setNickname("Kuku");
        buyer_crud.create(buyer);
        System.out.println("create"+buyer);

        buyer.setNickname("Kuku2");
        buyer_crud.update(buyer);
        System.out.println("update"+buyer);

        buyer_crud.delete(buyer);
        System.out.println("delete"+buyer);

        Role_CRUD role_crud=new Role_CRUD();
        Role role=role_crud.read(1);
        System.out.println(role);
        System.out.println("readAll:");
        role_crud.readAll();

        Good_CRUD good_crud =new Good_CRUD();
        Good good= good_crud.read(1);
        System.out.println("read"+good);

        good.setName("Kuku");
        good_crud.create(good);
        System.out.println("create"+good);

        good.setName("Kuku2");
        good_crud.update(good);
        System.out.println("update"+good);

        good_crud.delete(good);
        System.out.println("delete"+good);

        Basket_CRUD basket_crud =new Basket_CRUD();
        Basket basket= basket_crud.read(1);
        System.out.println("read"+basket);

        basket.setFk_goods(1);
        basket_crud.create(basket);
        System.out.println("create"+basket);

        basket.setFk_goods(1);
        basket_crud.update(basket);
        System.out.println("update"+basket);

        basket_crud.delete(basket);
        System.out.println("delete"+basket);


    }
}
