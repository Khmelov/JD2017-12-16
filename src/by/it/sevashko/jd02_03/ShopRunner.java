package by.it.sevashko.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShopRunner {

    public static void main(String[] args) {
        System.out.println("Магазин открылся");
        new BuyerRunner().start();  //запуск покупателей
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(new Cashier(Dispatcher.getCashierNumber()));
        while (Dispatcher.allBuyersServiced()){
            if ((Dispatcher.getQueSize())/5+1 > Dispatcher.cashierCount() && Dispatcher.cashierCount() < 5){
                pool.execute(new Cashier(Dispatcher.getCashierNumber()));
            }
            else Thread.yield();
        }
        pool.shutdown();
        System.out.println("Магазин закрылся");
    }
}
