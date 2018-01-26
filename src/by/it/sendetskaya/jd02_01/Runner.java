package by.it.sendetskaya.jd02_01;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {

    static Queue<Buyer> queue=new LinkedList<>();
    private static int countBuyer=0;
    private static boolean pensioneer=false;

    public static void main(String[] args) {

        for (int second = 0; second < 120; second++) {

            if ((second>0&&second<=30)||(second>60&&second<=90)) {
                while (countBuyer <= (10 + second)) {
                    addQueue();
                }
            }
            else
            {
                while (countBuyer<=(40+(30-second)))
                {
                    addQueue();
                    }
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

    private static void addQueue() {
        int count = Helper.getRandom(2);
        for (int i = 0; i <= count; i++) {
            ++countBuyer;
            if (countBuyer % 4 == 0) {
                pensioneer = true;
            } else pensioneer = false;
            Buyer b = new Buyer(countBuyer, pensioneer);

            b.start();
            queue.add(b);
        }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
