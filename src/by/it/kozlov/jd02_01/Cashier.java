package by.it.kozlov.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    private int number;

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
                if (check.size() > 0) {
                    System.out.println(this + "печатаем чек для " + b);
                    System.out.println(this + "в корзине у покупателя:");
                    int sum = 0;
                    for (Map.Entry<String, Double> entry : check.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                        sum += entry.getValue();
                    }
                    System.out.println(this + b.toString() + "приобрёл товаров на сумму: " + sum + " Рублей");
                } else {
                    System.out.println(this + " Покупатель ничего не приобрёл");
                }
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
