package by.it.kozlov.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashier implements Runnable {
    private int number;
    private static final Lock lock = new ReentrantLock();
    private static double allPrice = 0;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "открыл кассу");
        while (!Dispetcher.allBuyerComplete()) {
            Buyer b = Dispetcher.extractFromQueue();
            if (b != null) {
                HashMap<String, Double> check;
                check = new HashMap<>(b.getGoods());

                System.out.println(this + "Начало обслуживания " + b);
                Helper.sleep(2000, 5000);
                System.out.print("---------------------------------------------------------------");
                System.out.println("---------------------------------------------------------------");
                if (check.size() > 0) {
                    System.out.print("                                                                  ");
                    System.out.println(this);
                    System.out.print("                                                                  ");
                    System.out.println("чек для" + b);

                    double sum = 0;
                    for (Map.Entry<String, Double> entry : check.entrySet()) {
                        System.out.print("                                                                  ");
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                        sum += entry.getValue();
                    }
                    System.out.print("                                                                  ");
                    System.out.println(this + b.toString() + "общая сумма: " + sum + " Рублей");
                    try {
                        lock.lock();
                        allPrice+=sum;
                    }finally {
                        lock.unlock();
                    }


                } else {
                    System.out.print("                                                                  ");
                    System.out.println(this + "нет покупок");
                }
                System.out.print("---------------------------------------------------------------");
                System.out.println("---------------------------------------------------------------");
                System.out.print("===============================================================");
                System.out.print("======================================================  ");
                System.out.println(allPrice);

                System.out.println(this + " Конец обслуживания " + b);
                synchronized (b) {
                    b.notify();
                }
            } else
                Thread.yield();
        }
        System.out.println(this + "закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number + " ";
    }
}
