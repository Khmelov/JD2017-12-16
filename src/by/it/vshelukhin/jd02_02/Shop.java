package by.it.vshelukhin.jd02_02;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {
    final static Object flagSyncBuyer = new Object();
    final static Object flagSyncCasher = new Object();
    final static Lock lockConcurrent = new ReentrantLock();

    static List<Integer> quantityBuyer = new ArrayList<>();
    static List<Integer> quantityCasier = new ArrayList<>();
    static List<Integer> quantityBuyerInQueue = new ArrayList<>();

    static volatile Set<Buyer> buyersAll = new HashSet<>();
    static volatile List<Cashier> cashierAll = new ArrayList<>();

    static ArrayDeque<Buyer> queueBuyers = new ArrayDeque<>();
    static ArrayDeque<Buyer> queueBuyersPens = new ArrayDeque<>();
    //static ArrayDeque<Cashier> cashierAll = new ArrayDeque<>();


    static void addBuyerToQueue (Buyer b){
        synchronized (flagSyncBuyer) {
            if (b.pensioneer) queueBuyersPens.addLast(b);
            else queueBuyers.addLast(b);
        }
    }

    static Buyer takeBuyerFromQueue (){
        synchronized (flagSyncBuyer) {
            Buyer b = queueBuyersPens.pollFirst();
            if (b == null) b = queueBuyers.pollFirst();
            return b;
        }
    }

    static int getSizeQueue(){
        synchronized (flagSyncBuyer) {
            return queueBuyers.size() + queueBuyersPens.size();
        }
    }

    static void addCasher(Cashier cashier){
        synchronized (flagSyncCasher) {
            cashierAll.add(cashier);
        }
    }

    static void deleteCasher(Cashier cashier){
        synchronized (flagSyncCasher) {
            cashierAll.remove(cashier);
        }
    }

    static int getNumberAllCashier(){
        synchronized (flagSyncCasher) {
            return cashierAll.size();
        }
    }

    static void addBuyer(Buyer buyer){
        lockConcurrent.lock();
        buyersAll.add(buyer);
        lockConcurrent.unlock();
    }

    static void deleteBuyer(Buyer buyer){
        lockConcurrent.lock();
        buyersAll.remove(buyer);
        lockConcurrent.unlock();
    }

    static int getNumberAllBuyers(){
        int temp;
        lockConcurrent.lock();
        temp = buyersAll.size();
        lockConcurrent.unlock();
        return temp;
    }
}
