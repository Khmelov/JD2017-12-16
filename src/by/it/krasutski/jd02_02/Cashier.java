package by.it.krasutski.jd02_02;

import java.util.Map;

public class Cashier implements Runnable {

    private static int numOfCashiers = 0;
    private int cashierNumber;
    public volatile static double totalSum = 0;
    private boolean isOpen = false;

    Cashier(int cashierNumber) {
        this.cashierNumber = cashierNumber;
    }

    public static int getNumOfCashiers() {
        return numOfCashiers;
    }

    public void setIsOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void run() {
        numOfCashiers++;
        isOpen = true;
        System.out.println(this + " открыл кассу.");
        while (Dispatcher.allBuyerComplete() && isOpen) {
            Buyer buyer = Dispatcher.getPensionerQueueSize() == 0
                    ? Dispatcher.extractBuyerFromQueue() :
                    Dispatcher.extractBuyerFromPensionerQueue();
            if (buyer != null) {
                System.out.println(this + " начал обслуживать " + buyer + ".");
                Helper.sleep(200, 500);
                System.out.println(this + " печатает чек для " + buyer + ".");
                getSum(buyer);
                System.out.println(this + " закончил обслуживать " + buyer + ".");
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Thread.yield();
        }
        numOfCashiers--;
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + cashierNumber;
    }

    private void getSum(Buyer buyer) {
        double sum = 0.0;
        for (Map.Entry<String, Double> good : buyer.getBasket().getGoodsInBasket().entrySet()) {
            sum += good.getValue();
        }
        synchronized (Cashier.class) {
            totalSum += sum;
        }
        System.out.println("Чек на сумму: " + sum);
    }
}
