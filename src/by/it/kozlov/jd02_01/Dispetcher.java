package by.it.kozlov.jd02_01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispetcher{
    private volatile static int countBuyer = 0;
    private static int completeBuyer = 0;
    private final static BlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);

    private final static int PLAN=100;

    static int incCountBuyer() {
        return ++countBuyer;
    }

    synchronized static boolean allBuyerComplete() {
        return (countBuyer > 0) && (completeBuyer == countBuyer);
    }

    synchronized static int incCompleteBuyer() {
        return ++completeBuyer;
    }

    synchronized static void printCounts() {
        System.out.printf("\tДиспетчер: Всего клиентов %d. Из них обслужено %d\n", countBuyer, completeBuyer);
    }

    static void addToQueue(Buyer b) {
        synchronized (queue) {
            try {
                queue.put(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static Buyer extractFromQueue() {
        synchronized (queue) {
            return queue.poll();
        }
    }

    static Buyer readFirstQueue() {
        synchronized (queue) {
            return queue.peek();
        }
    }

    static int getSizeQueue() {
        synchronized (queue) {
            return queue.size();
        }
    }


}
