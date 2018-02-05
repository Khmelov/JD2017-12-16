package by.it.sendetskaya.jd02_01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue {
    private final static BlockingQueue<Cashier> queueCashier=new ArrayBlockingQueue<>(5);
    public static int numberCashier = 0;

    static void addToQueue (Cashier c)
    {
        try {
            queueCashier.put(c);
            numberCashier++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Cashier delFromQueue ()
    {
        Cashier cashier;
        cashier=queueCashier.poll();
        numberCashier--;
        return cashier;
    }

}
