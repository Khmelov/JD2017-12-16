package by.it.akhmelev.jd02_02.classwork2;

import java.util.LinkedList;

class Dispatcher {

    //all types sync

    private volatile static int countBuyer = 0; //from main ++

    private static int completeBuyer = 0; //from Buyer sync

    private final static LinkedList<Buyer> queue = new LinkedList<>();


    static int incCountBuyer(){ //volatile
        return ++countBuyer;
    }

    //счетчики синхронизированы по монитору Dispatcher.class
    synchronized static boolean allBuyerComplete() {
            return (countBuyer > 0) && (completeBuyer == countBuyer);
    }

    synchronized static int incCompleteBuyer(){ //volatile
        return ++completeBuyer;
    }

    synchronized static void printCounts(){
        System.out.printf("\tDispatcher: Всего клиентов %d. Из них обслужено %d\n",countBuyer,completeBuyer);
    }


    //очередь синхронизирована по монитору queue
    static void addToQueue(Buyer b) {
        synchronized (queue) {
            queue.addLast(b);
        }
    }

    static Buyer extractFromQueue() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }

    static Buyer readFirstQueue() {
        synchronized (queue) {
            return queue.peekFirst();
        }
    }

    static int getSizeQueue() {
        synchronized (queue) {
            return queue.size();
        }
    }

}
