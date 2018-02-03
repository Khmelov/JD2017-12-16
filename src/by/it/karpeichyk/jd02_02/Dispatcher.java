package by.it.karpeichyk.jd02_02;


import java.util.LinkedList;

/**
 * Created by user on 29.01.2018.
 */
public class Dispatcher {
    private volatile static int countBuyer = 0;

    private static int completeBuyer = 0;

    private final static LinkedList<Byer> queue = new LinkedList<>();

    static int incCountByer() {
        return ++countBuyer;
    }

    synchronized static boolean allByerComplete() {
        return (countBuyer > 0) && (completeBuyer == countBuyer);
    }

    synchronized static int incCommpleteByer() {
        return ++completeBuyer;
    }

    synchronized static void printCounts() {
        System.out.printf("\tDispatcher: Всего клиентов %d. Из них обслужено %d\n", countBuyer, completeBuyer);
    }

    static void addToQueue(Byer b) {
        synchronized (queue) {
            queue.addLast(b);
        }
    }

    static Byer extracrToQueue() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }

    static Byer ReadFirstToQueue() {
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
