package by.it.vshelukhin.jd02_03;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Shop {

    final static int PLAN = 100;
    final static AtomicInteger buyerCount = new AtomicInteger(0);
    final static AtomicInteger buyerChooseCount = new AtomicInteger(0);

    static List<Integer> quantityBuyerInShop = new ArrayList<>();
    static List<Integer> quantityCasierWorked = new ArrayList<>();
    static List<Integer> quantityChooseBuyer = new ArrayList<>();
    static List<Integer> quantityBuyerInQueue = new ArrayList<>();

    static final CopyOnWriteArraySet buyersAllInShop = new CopyOnWriteArraySet();
    static final CopyOnWriteArrayList<Cashier> cashierAllWorked = new CopyOnWriteArrayList<>();

    static final BlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(30);    //почему размер е фикс?


//    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            System.out.println(queue.size());
//            try {
//                queue.put(new Buyer(Integer.toString(i)));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(queue.size());
//    }

    static void addBuyerToQueue (Buyer b){
        while (queue.size()>=30){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer takeBuyerFromQueue (){
        return queue.poll();
    }

    static int getSizeQueue(){
        return queue.size();
    }

    static void addCasherInWork(Cashier cashier){
        cashierAllWorked.add(cashier);
    }

    static void closeCasher(Cashier cashier){
        cashierAllWorked.remove(cashier);
    }

    static int getNumberAllCashierInWork(){
        return cashierAllWorked.size();
    }

    static void addBuyer(Buyer buyer){
        buyersAllInShop.add(buyer);
    }

    static void deleteBuyer(Buyer buyer){
        buyersAllInShop.remove(buyer);
    }

    static int getNumberAllBuyers(){
        return buyersAllInShop.size();
    }

    static void buyerChooseStart(){
        buyerChooseCount.incrementAndGet();
    }

    static void buyerChooseFinish(){
        buyerChooseCount.decrementAndGet();
    }

    static int buyerChooseCurrentNumber(){
        return buyerChooseCount.get();
    }

    static void incBuyerCount(){
        buyerCount.incrementAndGet();
    }

    static boolean isPlanComplete(){
        if (buyerCount.get() >= PLAN) return true;
        return false;
    }
}
