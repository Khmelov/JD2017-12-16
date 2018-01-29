package by.it.patsko.jd02_02;


import java.util.LinkedList;

public class Queue {
    private final static LinkedList<Buyer> queue = new LinkedList<Buyer>();
    private final static LinkedList<Buyer> pensionerQueue = new LinkedList<Buyer>();

    private volatile static int numOfAllCustomers = 0;       //количество всех покупателей в магазине(бывшие и настоящие)

    private static int numOfServedCustomers = 0;     //количество обслуженных покупателей

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

    static void showQueue() {
        StringBuilder result=new StringBuilder();
        synchronized (queue) {
            result.append("ОЧЕРЕДЬ            : ");
            for (Buyer aQueue : queue) result.append(aQueue).append(" ");
            result.append("\n");
        }
        synchronized (pensionerQueue) {
            result.append("ОЧЕРЕДЬ ПЕНСИОНЕРОВ: ");
            for (Buyer aQueue : pensionerQueue) result.append(aQueue).append(" ");
            result.append("\n");

        }
        System.out.println(result);
    }
}
