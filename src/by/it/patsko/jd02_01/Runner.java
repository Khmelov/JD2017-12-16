package by.it.patsko.jd02_01;

import java.util.LinkedList;
import java.util.Queue;

class Runner {
    static Queue<Buyer> queue=new LinkedList<>();
    static int countBuyer=0;
    public static void main(String[] args) {
        for (int second = 0; second < 12; second++) {
            int count=Helper.getRandom(2);
            for (int i = 0; i <= count; i++) {
                Buyer b=new Buyer(++countBuyer);
                b.start();
                queue.add(b);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* Buyer b=new Buyer(++countBuyer);
        b.start();*/
        while (queue.size()>0){
            for (Buyer buyer : queue) {
                try {
                    buyer.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Все вышли");
    }
}
