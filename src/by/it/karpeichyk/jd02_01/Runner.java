package by.it.karpeichyk.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by user on 27.01.2018.
 */
public class Runner {
    static Queue<Byer> queue=new ArrayDeque<>();
    private static int countByer=0;

    public static void main(String[] args) {
        for (int second = 0; second <12 ; second++) {
            int count=Helper.getRandom(2);
            for (int i = 0; i <=count ; i++) {
                Byer b = new Byer(++countByer);
                b.start();
                queue.add(b);

            }
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        while (queue.size()>0){
            for (Byer byer:queue) {
                //todo bad thread
                try {
                    byer.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
        System.out.println("Все вышли!!");
    }
}
