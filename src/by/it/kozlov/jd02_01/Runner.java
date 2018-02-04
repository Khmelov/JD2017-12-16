package by.it.kozlov.jd02_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Runner: Магазин открыт");
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier c = new Cashier(i);
            pool.execute(c);
        }

        for (int second = 0; second < 120; second++) {
            int count = Helper.getRandom(2);
            for (int i = 0; i <= count; i++) {
                if (!Dispetcher.planComplete()) {
                    Buyer b = new Buyer(Dispetcher.incCountBuyer());
                    System.out.println("Runner: Новый " + b);
                    Dispetcher.printCounts();
                    b.start();
                }
            }

            if (Dispetcher.planComplete()) break;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!Dispetcher.allBuyerComplete()) {
            Buyer any = Dispetcher.readFirstQueue();
            if (any != null)
                try {
                    any.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Runner: Все вышли");
        pool.shutdown();
        Helper.sleep(100, 200);
        System.out.println("Runner: Магазин закрыт");

    }
}
