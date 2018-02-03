package by.it.karpeichyk.jd02_03;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    private final static  int PLAN=100;
    private final static AtomicInteger countBuyer = new AtomicInteger(0);

    private final static  AtomicInteger completeBuyer = new  AtomicInteger(0);

    private final static BlockingQueue<Byer> queue = new PriorityBlockingQueue<Byer>(30);

    static int incCountByer()
    {
        return countBuyer.incrementAndGet();
    }

     static boolean allByerComhlete() {
        return
                (countBuyer.get() > 0) && (completeBuyer.get() == countBuyer.get());
    }

     static int incCommpleteByer() {
        return completeBuyer.incrementAndGet();
    }

    synchronized static void printCounts() {
        System.out.printf("\tDispatcher: Всего клиентов %d. Из них обслужено %d\n", countBuyer.get(), completeBuyer.get());
    }

    static void addToQueue(Byer b) {
        try {
             queue.put(b);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    static Byer extracrToQueue() {return queue.poll();}

    static Byer ReadFirstToQueue() {return queue.peek();}


    public  static boolean planComplete(){return  (countBuyer.get()>=PLAN);}

}
