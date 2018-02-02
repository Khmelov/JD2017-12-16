package by.it.krasutski.jd02_03;

import java.util.Map;

public class Cashier extends Thread {

    private int number;
    static double totalSum = 0;


    Cashier(int number) {
        super(String.format("Кассир №%d", number));
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");
        while (Dispatcher.allBuyersServiced()) {
            Buyer buyer = Dispatcher.getBuyer();
            if (buyer != null) {
                System.out.println(this + " начал обслуживать " + buyer + ".");
                Helper.sleep(200, 500);
                System.out.println(this + " печатает чек для " + buyer + ".");
                getSum(buyer);
                System.out.println(this + " закончил обслуживать " + buyer + ".");
                synchronized (buyer) {
                    try {
                        Thread.sleep(Helper.getRandom(200, 500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    buyer.notify();
                }
            }
            if (Dispatcher.getQueueSize() / 5 + 1 < Dispatcher.cashierCount()) {
                break;
            }
        }
        Dispatcher.addToClosedCashiers(this.number);
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString() {
        return this.getName() + "";
    }

    private void getSum(Buyer buyer) {
        double sum = 0.0;
        for (Map.Entry<String, Double> good : buyer.getBasket().getGoodsInBasket().entrySet()) {
            sum += good.getValue();
        }
        synchronized (Cashier.class) {
            totalSum += sum;
        }
        System.out.println("Чек на сумму: " + sum + " рублей.");
    }
}
