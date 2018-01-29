package by.it.sevashko.jd02_02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Dispatcher {

    private static int buyerCount = 0;
    private static int servicedBuyers = 0;
    private final static LinkedList<Buyer> queue = new LinkedList<>();
    private final static Set<Cashier> workingCashiers = new HashSet<>();

    static int getBuyerNumber(){
        return ++buyerCount;
    }

    static void addToQue(Buyer buyer){
        synchronized (queue){
            queue.addLast(buyer);
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
        return queue.pollFirst();
    }

    synchronized static boolean AllBuyersServed(){
        return ((buyerCount <= 0) || (servicedBuyers != buyerCount));
    }

    static void addToCashierSet(Cashier cashier){
        synchronized (workingCashiers){
            workingCashiers.add(cashier);
        }
    }

    static int getCashierCount() {
        synchronized (workingCashiers) {
            return workingCashiers.size();
        }
    }

    static boolean removeFromWorkingCashiers(Cashier cashier){
        synchronized (workingCashiers) {
            if (Dispatcher.getCashierCount() > Dispatcher.getQueSize()/5+1 && Dispatcher.getCashierCount() != 1) {
                workingCashiers.remove(cashier);
                return true;
            }
            return false;
        }
    }
}
