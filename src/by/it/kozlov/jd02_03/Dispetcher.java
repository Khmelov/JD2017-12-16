package by.it.kozlov.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispetcher {
    private final static int PLAN = 100;
    private final static AtomicInteger countBuyer = new AtomicInteger(0);
    private final static AtomicInteger completeBuyer = new AtomicInteger(0);
    public final static AtomicInteger holeBuyer = new AtomicInteger(0);
    private final static BlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);

    static int incCountBuyer() {
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

    static int getCompleteBuyer() {
        return completeBuyer.get();
    }

    static int getCountBuyer() {
        return countBuyer.get();
    }

    static void printCounts() {
        System.out.printf("\tДиспетчер: Всего клиентов %d. Из них обслужено %d\n", countBuyer.get(), completeBuyer.get());
    }

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
        return (countBuyer.get() >= PLAN);
    }

    public static int getQueueSize() {
        return countBuyer.get() - completeBuyer.get() - holeBuyer.get();
    }
}
