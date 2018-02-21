package by.it.patsko.jd03_02.crud;

import java.sql.SQLException;

public class CRUDtestRunner {
    public static void main(String[] args) throws SQLException {
        BuyerCRUD buyerCRUD = new BuyerCRUD();
        Buyer buyer = buyerCRUD.read(3);
        System.out.println(buyer);
        buyer.setLogin("buyer10");
        buyerCRUD.update(buyer);
        System.out.println(buyer);
        if (buyerCRUD.delete(buyer)) System.out.println("Покупатель удален");
        if (buyerCRUD.create(buyer)) System.out.println("Покупатель создан");


        System.out.println(new RoleCRUD().read(1));
    }
}

