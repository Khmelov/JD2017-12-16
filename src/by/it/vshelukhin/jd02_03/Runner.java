package by.it.vshelukhin.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorChashier = Executors.newFixedThreadPool(5);

        int numBuyer = 1;
        int shopWork = 120;
        int time = 0;
        while ((shopWork > 0) || (Shop.getNumberAllBuyers() > 0)){

            System.out.println(secMark(time));
            System.out.println(buyersStatusAndCommonMoney());
            Shop.quantityChooseBuyer.add(time, Shop.buyerChooseCurrentNumber());


            if ((shopWork > 0) && !Shop.isPlanComplete()){
                int newBuyers = HelpRnd.getNewBuyer(time);
                while (newBuyers != 0) {
                    if (Shop.isPlanComplete()) continue;
                    Buyer b = new Buyer(Integer.toString(numBuyer++));
                    Thread t = new Thread(b, b.name);
                    t.start();
                    Shop.incBuyerCount();
                    newBuyers--;
                }
            }
            Shop.quantityBuyerInShop.add(time, Shop.buyersAllInShop.size());

            int sizeQueue = Shop.getSizeQueue();
            Shop.quantityBuyerInQueue.add(time, sizeQueue);

            int newCeshier = HelpRnd.getNewCashier(sizeQueue);
            for (int j = 0; j < newCeshier; j++) {
                Cashier cashier = new Cashier(Cashier.getNumberFreeCashier());
                Shop.addCasherInWork(cashier);
                executorChashier.execute(cashier);
            }
            Shop.quantityCasierWorked.add(time, Shop.getNumberAllCashierInWork());

            Thread.sleep(1000);
            shopWork--;
            time++;
        }
        executorChashier.shutdown();


        System.out.println();
        System.out.println("Посещаемость магазина:");
        for (int i = 0; i < Shop.quantityBuyerInShop.size(); i++) {
            System.out.printf("%3d секунда:  %3d человек в магазе  %3d человек выбирают  %3d человек в очереди  %3d кассиров\n", i + 1, Shop.quantityBuyerInShop.get(i),Shop.quantityChooseBuyer.get(i), Shop.quantityBuyerInQueue.get(i), Shop.quantityCasierWorked.get(i));
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

    private  static StringBuilder buyersStatusAndCommonMoney(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 175; i++) {
            sb.append(" ");
        }
        sb.append("Размер очереди: ");
        sb.append(Shop.getSizeQueue());
        sb.append("     ");
        sb.append("Общая выручка: ");
        sb.append(Kassa.getCurrentAllMoney());
        sb.append("\n");
        for (int i = 0; i < 175; i++) {
            sb.append(" ");
        }
        sb.append("Выбирают товар: ");
        sb.append(Shop.buyerChooseCurrentNumber());
        sb.append("\n");
        for (int i = 0; i < 175; i++) {
            sb.append(" ");
        }
        sb.append("Всего в магазине: ");
        sb.append(Shop.getNumberAllBuyers());

        return sb;
    }
}
