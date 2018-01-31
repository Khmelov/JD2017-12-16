package by.it.krasutski.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Магазин открылся");
        for (int second = 0; second < 60; second++) {
            int count = Helper.getRandom(5);
            for (int i = 0; i <= count; i++) {
                Buyer b = new Buyer(Dispatcher.getNumber());
                b.start();
            }
            Thread.sleep(100);
            if (Dispatcher.planComplete()) break;
        }
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(new Cashier(Dispatcher.getCashierNumber()));
        while (Dispatcher.allBuyersServiced()){
            if ((Dispatcher.getQueueSize())/5+1 > Dispatcher.cashierCount() && Dispatcher.cashierCount() < 5){
                pool.execute(new Cashier(Dispatcher.getCashierNumber()));
            }
            else Thread.yield();
        }
        pool.shutdown();
        System.out.println("Все вышли.");
        Helper.sleep(100, 200);
        System.out.println("Количество покупателей в очереди: " +
                Dispatcher.getQueueSize() + ".");
        if (Dispatcher.getServedCustomers() == Dispatcher.getAllCustomers())
            System.out.println("Магазин закрыт.\n");
        System.out.println("Количество обслуженных покупателей: " +
                Dispatcher.getServedCustomers() + ".");
        System.out.println("Количество покупателей всего: " +
                Dispatcher.getAllCustomers() + ".");
        System.out.println("Выручка магазина составила " +
                Cashier.totalSum + " рублей.");
    }
}
