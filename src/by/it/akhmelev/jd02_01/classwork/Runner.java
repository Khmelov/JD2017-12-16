package by.it.akhmelev.jd02_01.classwork;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {

    static Queue<Buyer> queue = new ArrayDeque<>();
    private static int countBuyer = 0;

    public static void main(String[] args) {
        for (int second = 0; second < 12; second++) {
            int count=Helper.getRandom(2);
            for (int i = 0; i <= count; i++) {
                Buyer b = new Buyer(++countBuyer);
                b.start();
                queue.add(b);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (queue.size()>0){
            //todo thread is bad
            for (Buyer buyer : queue) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Все вышли");
    }
}
