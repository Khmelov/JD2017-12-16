package by.it.sevashko.jd02_02;

import java.util.LinkedList;
import java.util.Queue;

public class Dispatcher {

    private static int buyerCount = 0;
    private static int servicedBuyers = 0;
    private final static Queue<Buyer> queue = new LinkedList<>();

    static int getBuyerNumber(){
        return ++buyerCount;
    }

    static void addToQue(Buyer buyer){
        synchronized (queue){
            queue.add(buyer);
        }
    }

    static int getQueSize(){
        synchronized (queue) {
            return queue.size();
        }
    }

    synchronized static void addServedBuyer(){
        servicedBuyers++;
    }

    static Buyer getBuyer(){
        return queue.poll();
    }

    synchronized static boolean AllBuyersServed(){
        return ((buyerCount > 0) && (servicedBuyers == buyerCount));
    }
}
