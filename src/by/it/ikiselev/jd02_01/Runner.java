package by.it.ikiselev.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {

    static Queue<Buyer> queue = new ArrayDeque<>();
    static int countBuyer = 0;
    static int idCountBuyer=0;

    public static void main(String[] args) {
        for (int second = 0; second < 61; second++) {
            int count=Helper.getRandom(2);
            boolean bhelp=true;
            if (second % 60 == 0) count=10;
            else {
                if (second % 60 < 30){//для секунд с 1-ой по 30-ю
                    while (bhelp){
                        count=Helper.getRandom(2);
                        if (countBuyer+count>=second+10) bhelp=false;
                    }
                }
                else if (countBuyer<=40+(30-second)) count=Helper.getRandom(2);
                     else count=-1;
            }
            for (int i = 0; i <= count; i++) {
                ++countBuyer;
             //   countBuyer=countBuyer+1;
                Buyer b = new Buyer(++idCountBuyer);
                //для создания пенсионера, в среднем - каждый четвертый
                int isPensioneer=Helper.getRandom(3);
                if (isPensioneer==1) b.pensioneer=true;
                System.out.println("я зашел на "+second+" секунде");
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
