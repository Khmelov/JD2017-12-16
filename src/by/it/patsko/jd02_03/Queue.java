package by.it.patsko.jd02_03;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue {
    private final static int PLAN=100;
    private final static BlockingQueue<Buyer> queue = new PriorityBlockingQueue<>();
    private static AtomicInteger numOfAllCustomers = new AtomicInteger(0);       //количество всех покупателей в магазине(бывшие и настоящие)
    private static AtomicInteger numOfServedCustomers = new AtomicInteger(0);     //количество обслуженных покупателей


    public static int getNumOfAllCustomers() {
        return numOfAllCustomers.get();
    }

    public static int getNumOfServedCustomers() {
        return numOfServedCustomers.get();
    }

    public static int getQueueSize() {
        synchronized (queue) {
        return queue.size();
        }
    }

    static int incNumOfAllCustomers() {
        return numOfAllCustomers.incrementAndGet();
    }

    static int incNumOfServedCustomers() {
        return numOfServedCustomers.incrementAndGet();
    }

    static boolean allBuyerComplete() {
        return (numOfAllCustomers.get() > 0) &&
                (numOfServedCustomers.get() == numOfAllCustomers.get());
    }

    static void addBuyerToQueue(Buyer buyer) {
        try {
            queue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Buyer readFirstQueue() {
        return queue.peek();
    }

    static Buyer extractBuyerFromQueue() {
            return queue.poll();

    }
    public static boolean planComplete() {
        return (numOfAllCustomers.get()>=PLAN);
    }

    static void printQueue(){
        StringBuilder result = new StringBuilder();
        result.append("Первый в очереди: ").append(readFirstQueue()).append("\n");
            result.append("ОЧЕРЕДЬ: ");
            synchronized (queue) {
                for (Buyer aQueue : queue) result.append(aQueue).append(" ");
            }
            result.append("\n");
            System.out.println(result);
    }
}