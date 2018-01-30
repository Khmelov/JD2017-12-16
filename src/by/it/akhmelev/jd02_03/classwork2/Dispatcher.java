package by.it.akhmelev.jd02_03.classwork2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    //all types sync
    private final static int PLAN=100;

    private final static AtomicInteger countBuyer = new AtomicInteger(0); //from main ++

    private final static AtomicInteger completeBuyer = new AtomicInteger(0); //from Buyer sync

    private final static BlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);


    static int incCountBuyer() { //volatile
        return countBuyer.incrementAndGet();
    }

    static boolean allBuyerComplete() {
        return (
                countBuyer.get() > 0) &&
                (completeBuyer.get() == countBuyer.get()
                );
    }

    static int incCompleteBuyer() {
        return completeBuyer.incrementAndGet();
    }

    static void printCounts() {
        System.out.printf(
                "\tDispatcher: Всего клиентов %d. Из них обслужено %d\n",
                countBuyer.get(),
                completeBuyer.get());
    }


    //очередь синхронизирована по монитору queue
    static void addToQueue(Buyer b) {
        try {
            queue.put(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extractFromQueue() {
        return queue.poll();
    }

    static Buyer readFirstQueue() {
        return queue.peek();
    }

    public static boolean planComplete() {
        return (countBuyer.get()>=PLAN);
    }

    /* пока не требуется, но если нужно, то читать лучше так:

    static int getSizeQueue() {
        synchronized (queue) {
            return queue.size();
        }
    }
    */

}
