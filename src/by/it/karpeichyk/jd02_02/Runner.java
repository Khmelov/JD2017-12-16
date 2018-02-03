package by.it.karpeichyk.jd02_02;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by user on 27.01.2018.
 */
public class Runner {
    //static Queue<Byer> queue=new ArrayDeque<>();
   // private static int countByer=0;

    public static void main(String[] args) {
        System.out.println("Runner: Магазин открыт");
        for (int i = 1; i <= 5; i++) {
            Cashier c=new Cashier(i);
            new Thread(c).start();
        }
        for (int second = 0; second <20 ; second++) {
            int count= Helper.getRandom(2);
            for (int i = 0; i <=count ; i++) {
                Byer b = new Byer(Dispatcher.incCountByer());
                System.out.println("Runner: Новый "+b);
                Dispatcher.printCounts();
                b.start();
            }
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        while (!Dispatcher.allByerComplete()){
            Byer first=Dispatcher.ReadFirstToQueue();
            if (first!=null)
                try {
                    first.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

        System.out.println("Все вышли!!");
        Helper.sleep(100,200);
        System.out.println("Runner:магазин закрыт");
    }}

