package by.it.karpeichyk.jd02_03;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 27.01.2018.
 */
public class Runner {
    //static Queue<Byer> queue=new ArrayDeque<>();
   // private static int countByer=0;

    public static void main(String[] args) {
        System.out.println("Runner: Магазин открыт");
        ExecutorService pool= Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier c=new Cashier(i);
            pool.execute(c);
        }
        for (int second = 0; second <12 ; second++) {
            int count= Helper.getRandom(2);
            for (int i = 0; i <=count ; i++) {
                if (!Dispatcher.planComplete()) {
                    Byer b = new Byer(Dispatcher.incCountByer());
                    System.out.println("Runner: Новый " + b);
                    Dispatcher.printCounts();
                    b.start();
                }
            }
            if (Dispatcher.planComplete()) break;


            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        while (!Dispatcher.allByerComhlete()){
            Byer first= Dispatcher.ReadFirstToQueue();
            if (first!=null)
                try {
                    first.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

        System.out.println("Все вышли!!");
        pool.shutdown();
        Helper.sleep(100,200);
        System.out.println("Runner:магазин закрыт");
    }}

