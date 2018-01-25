package by.it.sendetskaya.jd02_01;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {

    static Queue<Buyer> queue=new LinkedList<>();
    static int countBuyer=0;

    public static void main(String[] args) {

        for (int second = 0; second < 12; second++) {
            int count=Helper.getRandom(2);
            for (int i = 0; i <= count ; i++) {
                Buyer b=new Buyer((++countBuyer));
                b.start();
                queue.add(b);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (queue.size()>0)
        {
            //

            for (Buyer buyer : queue) {
                try {
                    buyer.join();
                    break;           //ОШИБКА! может уже не быть последнего покупателя? он мог уже выйти
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Все вышли");

    }

}
