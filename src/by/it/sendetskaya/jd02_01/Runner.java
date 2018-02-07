package by.it.sendetskaya.jd02_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static boolean pensioneer=false;

    public static void main(String[] args) {

        System.out.println("Runner: Магазин открыт");
        ///
        ExecutorService pool= Executors.newFixedThreadPool(5);
        ////
        for (int i = 1; i <= 5; i++) {
            Cashier cashier=new Cashier(i);
            pool.execute(cashier);
        }
        ////

        for (int second = 0; second < 120; second++) {

            if ((second>0&&second<=30)||(second>60&&second<=90)) {
                while (Dispetcher.allCountBuyer() <= (10 + second)) {
                    addQueue();
                }
            }
            else
            {
                while (Dispetcher.allCountBuyer()<=(40+(30-second)))
                {
                    addQueue();
                    }
                }
            if (Dispetcher.planComplete()) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ///

        while (!Dispetcher.allBuyerComplete())   ///изменено
        {
            Buyer first=Queue.readFirstQueue();   //ждет пока обслужат покупателя
            if (first!=null)
            {
                try {
                    first.join();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        pool.shutdown();
        System.out.println("Runner: Все вышли");
        Helper.sleep(100,200);
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("ВСЕГО |%10s|%10s|%10s|%10s|%10s|%5.2f|\n", "", "", "", "", "", Buyer.sumGeneral);

        //очереди кассиров нет, поэтому
        //тут просто подождем.
        Helper.sleep(100,200);
        System.out.println("Runner: Магазин закрыт");

    }

    private static void addQueue() {

            int count = Helper.getRandom(2);
            for (int i = 0; i <= count; i++){
                if (!Dispetcher.planComplete()){
                Dispetcher.incCountBuyer();
                if (Dispetcher.allCountBuyer() % 4 == 0) {
                    pensioneer = true;
                } else pensioneer = false;
                Buyer b = new Buyer(Dispetcher.allCountBuyer(), pensioneer);
                System.out.println("Runner: Новый " + b);
                b.start();
            }
        }

        try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
