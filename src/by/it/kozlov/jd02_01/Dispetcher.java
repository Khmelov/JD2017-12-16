package by.it.kozlov.jd02_01;

import java.util.LinkedList;

public class Dispetcher {
    private volatile static int countBuyer = 0;
    private static int completeBuyer = 0;
    private final static LinkedList<Buyer> queue = new LinkedList<>();

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
            queue.addLast(b);
        }
    }

    static Buyer extractFromQueue() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }

    static Buyer readFirstQueue() {
        synchronized (queue) {
            return queue.peekFirst();
        }
    }

    static int getSizeQueue() {
        synchronized (queue) {
            return queue.size();
        }
    }
}
