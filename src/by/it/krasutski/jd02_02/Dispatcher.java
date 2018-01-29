package by.it.krasutski.jd02_02;


import java.util.LinkedList;

public class Dispatcher {
    private final static LinkedList<Buyer> queue = new LinkedList<>();
    private final static LinkedList<Buyer> pensionerQueue = new LinkedList<>();

    private volatile static int numOfAllCustomers = 0;

    private static int numOfServedCustomers = 0;

    public static int getNumOfAllCustomers() {
        return numOfAllCustomers;
    }

    public static int getNumOfServedCustomers() {
        return numOfServedCustomers;
    }

    synchronized public static int getQueueSize() {
        return queue.size();
    }

    synchronized public static int getPensionerQueueSize() {
        return pensionerQueue.size();
    }

    synchronized static int incNumOfAllCustomers() {
        return ++numOfAllCustomers;
    }

    synchronized static int incNumOfServedCustomers() {
        return ++numOfServedCustomers;
    }

    synchronized static boolean allBuyerComplete() {
        return (numOfAllCustomers > 0) &&
                (numOfServedCustomers == numOfAllCustomers);
    }

    static void addBuyerToQueue(Buyer buyer) {
        if (!buyer.isPensioner())
            synchronized (queue) {
                queue.addLast(buyer);
            }
        else {
            synchronized (queue) {
                pensionerQueue.addLast(buyer);
            }
        }
    }

    static Buyer extractBuyerFromQueue() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }

    static Buyer extractBuyerFromPensionerQueue() {
        synchronized (pensionerQueue) {
            return pensionerQueue.pollFirst();
        }
    }

    static Buyer readFirstQueue() {
        synchronized (queue) {
            return queue.peekFirst();
        }
    }

    static Buyer readFirstPensionerQueue() {
        synchronized (pensionerQueue) {
            return queue.peekFirst();
        }
    }
}
