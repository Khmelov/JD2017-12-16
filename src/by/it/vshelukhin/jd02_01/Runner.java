package by.it.vshelukhin.jd02_01;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        int numberBuyer = 1;
        int shopWork = 120;
        for (int i = 0; i < shopWork; i++) {
            int newBuyers = HelpRnd.getNewBuyer(i);     //получаем количество новых покупателей с учётом заданного баланса
            while (newBuyers != 0) {
                Buyer b = new Buyer(Integer.toString(numberBuyer++));
                Thread t = new Thread(b, b.name);
                t.start();
                newBuyers--;
            }
            Shop.quantity.add(i,Shop.BuyersAll.size());
            Thread.sleep(1000);
        }
        Thread.sleep(10000);
        System.out.println();
        System.out.println("Посещаемость магазина:");
        for (int i = 0; i < Shop.quantity.size(); i++) {
            System.out.printf("%3d секунда:  %3d человек\n",i+1,Shop.quantity.get(i));
        }
        System.out.println();
        System.out.printf("Денежный оборот магазина составил: %.2f рублей.\n",Kassa.getCurrentAllMoney());
        System.out.printf("Всего посетило магазин %d покупателей.\n",Kassa.getNumberAllBuyers());
    }
}
