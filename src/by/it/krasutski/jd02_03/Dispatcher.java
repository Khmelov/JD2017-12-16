package by.it.krasutski.jd02_03;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private final static AtomicInteger countOfBuyers = new AtomicInteger(0);
    private static PriorityBlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);
    private final static int PLAN = 100;
    private final static AtomicInteger servedBuyers = new AtomicInteger(0);
    private final static PriorityBlockingQueue<Integer> closedCashiers = new PriorityBlockingQueue<>(5);
    private final static Semaphore tradingHall = new Semaphore(20);
    private final static Semaphore freeBaskets = new Semaphore(30);

    static {
        closedCashiers.add(1);
        closedCashiers.add(2);
        closedCashiers.add(3);
        closedCashiers.add(4);
        closedCashiers.add(5);
    }

    static int getNumber() {
        return countOfBuyers.incrementAndGet();
    }

    static void addServicedBuyer() {
        servedBuyers.incrementAndGet();
    }

    static boolean allBuyersServiced() {
        return (countOfBuyers.get() <= 0 || countOfBuyers.get() != servedBuyers.get());
    }

    public static int getAllCustomers() {
        return countOfBuyers.get();
    }

    public static int getServedCustomers() {
        return servedBuyers.get();
    }

    static boolean addToQueue(Buyer buyer) {
        return queue.size() < 30 && queue.offer(buyer);    //размер очереди не больше 30
    }

    static int getQueueSize() {
        return queue.size();
    }

    static Buyer getBuyer() {
        return queue.poll();
    }

    static boolean planComplete() {
        return countOfBuyers.get() >= PLAN;
    }


    static int cashierCount() {
        return 5 - closedCashiers.size();
    }

    static int getCashierNumber() {
        return closedCashiers.poll();
    }

    static void addToClosedCashiers(int number) {
        closedCashiers.put(number);
    }

    static boolean permitToEnterTradingHall() {
        return tradingHall.tryAcquire();
    }

    static void goFromTradingHall() {
        tradingHall.release();
    }

    static boolean getFreeBasket() {
        return freeBaskets.tryAcquire();
    }

    static void returnBasket(Buyer buyer) {
        System.out.println(buyer + " вернул корзину.");
        freeBaskets.release();
    }
}
