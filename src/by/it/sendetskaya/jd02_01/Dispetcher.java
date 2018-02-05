package by.it.sendetskaya.jd02_01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {

    private final static int plan=100;

    private final static BlockingQueue<Buyer> queue=new PriorityBlockingQueue<>(30);
    private final static AtomicInteger countBuyer=new AtomicInteger(0);       //buyer enter    from main  volatile
    private final static AtomicInteger completeBuyer=new AtomicInteger(0);   //buyer go out     from Buyer sync   их может быть много? поэтому volotile нельзя

    static boolean allBuyerComplete()
    {
           return (countBuyer.get()>0)&&(completeBuyer.get()==countBuyer.get());
    }

    static int incCountBuyer()   //volatile
    {
        return countBuyer.incrementAndGet();
    }

    static int incCompleteBuyer()
    {
        return completeBuyer.incrementAndGet();
    }
    static int allCountBuyer() {return countBuyer.get();}

    static void printCounts(){
        System.out.printf("\tDispatcher: Всего клиентов %d. Из них обслужено %d\n",
                countBuyer.get(),completeBuyer.get());
    }

    static void addLastToQueue (Buyer b)
    {
        try {
            queue.put(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer readFirstQueue() {
            return queue.peek();
    }

    static Buyer delFirstFromQueue ()
    {
         return queue.poll();
    }

    static int getSizeQueque ()
    {
            return queue.size();
    }

    public static boolean planComplete() {
        return countBuyer.get()>=plan;
    }
}
