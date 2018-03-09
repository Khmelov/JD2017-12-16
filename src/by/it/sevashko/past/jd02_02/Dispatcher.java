package by.it.sevashko.jd02_02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Dispatcher {

    private static int buyerCount = 0;
    private static int servicedBuyers = 0;
    private final static LinkedList<Buyer> queue = new LinkedList<>();
    private final static LinkedList<Buyer> queueForPensioner = new LinkedList<>();
    private final static Set<Cashier> workingCashiers = new HashSet<>();

    static int getBuyerNumber(){
        return ++buyerCount;
    }

    static void addToQue(Buyer buyer){
        synchronized (queue){
            if (buyer.isPensioner()) {
                queueForPensioner.addLast(buyer);
                System.out.println(buyer + "встал в очередь для пенсионеров");
            }
            else {
                queue.addLast(buyer);
                System.out.println(buyer + "встал в очередь");
            }
        }
    }

    static int getQueSize(){
        synchronized (queue) {
            synchronized (queueForPensioner) {
                return queue.size() + queueForPensioner.size();
            }
        }
    }

    synchronized static void addServedBuyer(){
        servicedBuyers++;
    }

    static Buyer getBuyer(){
        synchronized (queue) {
            synchronized (queueForPensioner) {
                if (queueForPensioner.size() > 0) return queueForPensioner.pollFirst();
                else return queue.pollFirst();
            }
        }
    }

    synchronized static boolean AllBuyersServed(){
        return ((buyerCount > 0) && (servicedBuyers == buyerCount));
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
            if (Dispatcher.getCashierCount() > Dispatcher.getQueSize()/5+2 && Dispatcher.getCashierCount() != 1 || AllBuyersServed()) {
                workingCashiers.remove(cashier);
                return true;
            }
            return false;
        }
    }
}
