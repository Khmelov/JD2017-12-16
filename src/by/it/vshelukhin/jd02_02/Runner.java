package by.it.vshelukhin.jd02_02;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        int numBuyer = 1;
        int shopWork = 120;
        int time = 0;
        while ((shopWork > 0) || (Shop.getNumberAllBuyers() > 0)){

            System.out.println(secMark(time));
            System.out.println(sizeQueueAndCommonMoney());

            if (shopWork > 0){
                int newBuyers = HelpRnd.getNewBuyer(time);     //получаем количество новых покупателей с учётом заданного баланса
                while (newBuyers != 0) {
                    Buyer b = new Buyer(Integer.toString(numBuyer++));
                    Thread t = new Thread(b, b.name);
                    t.start();
                    newBuyers--;
                }
            }
            Shop.quantityBuyer.add(time, Shop.buyersAll.size());

            int sizeQueue = Shop.getSizeQueue();
            Shop.quantityBuyerInQueue.add(time, sizeQueue);

            int newCeshier = HelpRnd.getNewCashier(sizeQueue);
            for (int j = 0; j < newCeshier; j++) {
                Cashier cashier = new Cashier(Cashier.getNumberFreeCashier());
                Thread thrCashier = new Thread(cashier, Integer.toString(cashier.getNumberCashier()));
                thrCashier.start();
                Shop.addCasher(cashier);
            }
            Shop.quantityCasier.add(time, Shop.getNumberAllCashier());

            Thread.sleep(1000);
            shopWork--;
            time++;
        }


        System.out.println();
        System.out.println("Посещаемость магазина:");
        for (int i = 0; i < Shop.quantityBuyer.size(); i++) {
            System.out.printf("%3d секунда:  %3d человек в магазе  %3d человек в очереди  %3d кассиров\n", i + 1, Shop.quantityBuyer.get(i), Shop.quantityBuyerInQueue.get(i), Shop.quantityCasier.get(i));
        }
        System.out.println();
        System.out.printf("Денежный оборот магазина составил: %.2f рублей.\n", Kassa.getCurrentAllMoney());
        System.out.printf("Всего посетило магазин %d покупателей.\n", Kassa.getNumberAllBuyers());
    }
    
    private static StringBuilder secMark(int sec){
        StringBuilder sb = new StringBuilder();
        sb.append("***");
        sb.append(sec);
        sb.append(" секунда");
        for (int i = 0; i < 220; i++) {
            sb.append("*");
        }
        return sb;
    }

    private  static StringBuilder sizeQueueAndCommonMoney(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 175; i++) {
            sb.append(" ");
        }
        sb.append("Размер очереди: ");
        sb.append(Shop.getSizeQueue());
        sb.append("     ");
        sb.append("Общая выручка: ");
        sb.append(Kassa.getCurrentAllMoney());

        return sb;
    }
}
