package by.it.sendetskaya.jd02_01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Cashier implements Runnable{

    private int number;
    //private static int numberCashier = 0;
    private final static BlockingQueue<Cashier> queueCashier=new ArrayBlockingQueue<>(5);


    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number+" ";
    }


    @Override
    public void run() {

        Queue.addToQueue(new Cashier(this.number));
        System.out.println(this + "открыл кассу.");

            while (!Dispetcher.allBuyerComplete()) {
                Buyer b = Dispetcher.delFirstFromQueue();
                if (b != null) {
                    System.out.println(this + "Начало обслуживания покупателя " + b);
                    Helper.sleep(200, 500);

                    System.out.println(this + "печатаем чек для " + b + " , сумма чека: " + Buyer.sum);

                    Helper.sleep(200, 500);
                    System.out.println(this + "Конец обслуживания покупателя " + b);
                    synchronized (b) {
                        b.notify();
                    }if (Dispetcher.getSizeQueque()/5>=Queue.numberCashier) {
                        Queue.addToQueue(new Cashier(this.number));
                        System.out.println(this + "открыл кассу.");
                    }
                    if (Dispetcher.getSizeQueque()/5<Queue.numberCashier&&Queue.numberCashier!=1) {
                        Queue.delFromQueue();
                        System.out.println(this + "закрыл кассу.");
                        Thread.yield();
                    }
                } else
                    //если пока нет работы, отдадим управление другим потокам
                    Thread.yield();
            }


    }

}
