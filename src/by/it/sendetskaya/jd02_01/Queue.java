package by.it.sendetskaya.jd02_01;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue {
    final static AtomicInteger countBacket=new AtomicInteger(0);
    private final static BlockingQueue<Cashier> queueCashier=new ArrayBlockingQueue<>(5);
    private final static AtomicInteger countBuyer=new AtomicInteger(0);       //buyer enter    from main  volatile
    private final static AtomicInteger countCashier=new AtomicInteger(0);   //buyer go out     from Buyer sync   их может быть много? поэтому volotile нельзя

    private final static BlockingQueue<Buyer> queue=new PriorityBlockingQueue<>(30);

    static BlockingQueue<Buyer> queueBacket=new ArrayBlockingQueue<>(20);
    private static Semaphore semaphore=new Semaphore(20);

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

    static int getSizeQueue ()
    {
        int count=countBuyer.get();
        count= queue.size();
        return count;
    }


    static void addCashierToQueue(Cashier c)
    {
        try {
            queueCashier.put(c);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Cashier delCashierFromQueue()
    {
        Cashier cashier;
        cashier=queueCashier.poll();

        return cashier;
    }

    static boolean inclQueueCashier(Cashier numberCashier){
        boolean flag=false;
        Iterator<Cashier> itr = queueCashier.iterator();
        while (itr.hasNext()) {
            if(itr.next().toString().equals(numberCashier.toString()))
                flag=true;
        }
        return flag;
    }

    static int getCashierQueueSize()
    {
        int count=countCashier.get();
        count= queueCashier.size();
        return count;
    }

    ////

    static boolean addBacketToQueue(Buyer b)
    {
        boolean flag=false;
        try {
            if(semaphore.tryAcquire()) {
                System.out.println(b + " взял корзину № " + countBacket.incrementAndGet());
                queueBacket.put(b);
                flag=true;
            }
            else {
                System.out.println(b + " пока ждет корзину");
                flag = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

    static void delBacketFromQueue(Buyer b) {
        queueBacket.poll();
        System.out.println(b+" отдал корзину № "+countBacket.getAndDecrement());
        //countBacket.decrementAndGet();

        semaphore.release();
        //return buyer;
    }

}
