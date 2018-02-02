package by.it.kozlov.jd02_01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispetcher {
    private final static int PLAN = 100;
    private final static AtomicInteger countBuyer = new AtomicInteger(0);
    private final static AtomicInteger completeBuyer = new AtomicInteger(0);
    private final static BlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);

    static int incCountBuyer() {
        return countBuyer.incrementAndGet();
    }

    synchronized static boolean allBuyerComplete() {
        return (countBuyer.get() > 0) && (completeBuyer.get() == countBuyer.get());
    }

    synchronized static int incCompleteBuyer() {
        return completeBuyer.incrementAndGet();
    }

    synchronized static void printCounts() {
        System.out.printf("\tДиспетчер: Всего клиентов %d. Из них обслужено %d\n", countBuyer.get(), completeBuyer.get());
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
