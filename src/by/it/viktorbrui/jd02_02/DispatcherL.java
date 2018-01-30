package by.it.viktorbrui.jd02_02;

import java.util.LinkedList;

class DispatcherL {

    private volatile static int countBuyer = 0;
    private static int complitBuyer = 0;
    private final static LinkedList<BuyerL> queue = new LinkedList<>();

    static int incCountBuyer(){ //volatile
        return ++countBuyer;
    }
    synchronized static boolean allBuyersComplite(){
        return (countBuyer>0)&&(complitBuyer==countBuyer);
    }
    synchronized static int inCompliteBuyers(){ //volatile
        return ++complitBuyer;
    }
    synchronized static void printCounts(){
        System.out.printf("\tDispatcherL: Всего клиентов %d. Из них обслужено %d\n",countBuyer,complitBuyer);
    }
    static void addToQueue(BuyerL b){
        synchronized (queue){
            queue.addLast(b);
        }
    }
    static BuyerL extractFromQueue(){
        synchronized (queue){
            return queue.pollFirst();
        }
    }
    static BuyerL readFirstQueue(){
        synchronized (queue){
            return queue.peekFirst();
        }
    }
    static int getSizeQueue(){
        synchronized (queue){
            return queue.size();
        }
    }
}
