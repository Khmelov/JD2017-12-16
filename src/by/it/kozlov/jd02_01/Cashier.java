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

    private void getDelimiter(String string, int num) {
        int leigh = 25 - string.length();
        for (int i = 0; i < 7; i++) {
            if (i == num - 1) {
                System.out.print("|" + string);
                for (int j = 0; j <= leigh; j++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            } else {
                System.out.print("|                          |");
            }

        }
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println(this + "открыл кассу");
        while (!Dispetcher.allBuyerComplete()) {
            if (this.number * 5 - 5 <= (Dispetcher.getQueueSize())) {
                Buyer b = Dispetcher.extractFromQueue();
                if (b != null) {
                    HashMap<String, Double> check;
                    check = new HashMap<>(b.getGoods());
                    synchronized (System.out) {
                        System.out.println(this + "Начало обслуживания " + b);
                        Helper.sleep(500, 1000);
                        if (check.size() > 0) {
                            getDelimiter(this.toString(), number);
                            getDelimiter(String.format("чек для " + b), number);

                            double sum = 0;
                            for (Map.Entry<String, Double> entry : check.entrySet()) {
                                getDelimiter(String.format(entry.getKey() + " : " + entry.getValue()), number);
                                sum += entry.getValue();
                            }
                            getDelimiter(String.format(b.toString() + "сумма: " + sum), number);
                            try {
                                lock.lock();
                                allPrice += sum;
                            } finally {
                                lock.unlock();
                            }


                        } else {
                            getDelimiter(String.format(this + "нет покупок"), number);
                        }
                        getDelimiter(Integer.toString(Dispetcher.getQueueSize()), 6);
                        getDelimiter(Double.toString(allPrice), 7);

                        System.out.println(this + " Конец обслуживания " + b);
                        synchronized (b) {
                            b.notify();
                        }
                    }
                } else Helper.sleep(999, 1000);
            } else Helper.sleep(999, 1000);
        }
        System.out.println(this + "закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + number + " ";
    }
}
