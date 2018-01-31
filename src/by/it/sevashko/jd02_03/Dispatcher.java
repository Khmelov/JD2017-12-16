package by.it.sevashko.jd02_03;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private final static AtomicInteger countOfBuyers = new AtomicInteger(0);
    private static PriorityBlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);
    private final static int plan = 100;
    private final static AtomicInteger servicedBuyers = new AtomicInteger(0);
    private final static PriorityBlockingQueue<Integer> closedCashiers = new PriorityBlockingQueue<>();
    private final static Semaphore tradingHall = new Semaphore(20);  //В зале не может выбирать товар больше, чем 20 покупателей (семафор).
    private final static Semaphore freeBaskets = new Semaphore(30);

    static {
        closedCashiers.add(1);
        closedCashiers.add(2);
        closedCashiers.add(3);
        closedCashiers.add(4);
        closedCashiers.add(5);
    }

    static int getNumber(){
        return countOfBuyers.incrementAndGet();
    }

    static void addServicedBuyer(){
        servicedBuyers.incrementAndGet();
    }

    static boolean allBuyersServiced(){
        return (countOfBuyers.get() <= 0 || countOfBuyers.get() != servicedBuyers.get());
    }

    static boolean addToQueue(Buyer buyer) {
        return queue.size() < 30 && queue.offer(buyer);    //размер очереди не больше 30
    }

    static int getQueSize(){
        return queue.size();
    }

    static Buyer getBuyer(){
            return queue.poll();
    }

    static boolean planComplete(){
        return countOfBuyers.get() >= plan;
    }


    static int cashierCount(){
        return 5 - closedCashiers.size();
    }

    static int getCashierNumber(){
        return closedCashiers.poll();
    }

    static void addToClosedCashiers(int number){
        closedCashiers.put(number);
    }

    static int getBuyersCount(){
        return countOfBuyers.get() - servicedBuyers.get();
    }

    static boolean permitToEnterTradingHall(){
        return tradingHall.tryAcquire();
    }

    static void goFromTradingHall(){
        tradingHall.release();
    }

    static boolean getFreeBascket(){
        return freeBaskets.tryAcquire();
    }

    static void returnBasket(Buyer buyer){
        System.out.println(buyer + "вернул корзину");
        freeBaskets.release();
    }
}
