package by.it.akhmelev.jd02_02.classwork2;

import java.util.LinkedList;

class Dispatcher {

    //all types sync

    private volatile static int countBuyer = 0; //from main ++

    private static int completeBuyer = 0; //from Buyer sync

    private final static LinkedList<Buyer> queue = new LinkedList<>();


    synchronized static boolean allBuyerComplete() {
            return (countBuyer > 0) && (completeBuyer == countBuyer);
    }

    static int incCountBuyer(){ //volatile
        return ++countBuyer;
    }
    synchronized static int incCompleteBuyer(){ //volatile
        return ++completeBuyer;
    }

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

    static int getSizeQueue() {
        synchronized (queue) {
            return queue.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(queue.pollFirst());
    }
}
