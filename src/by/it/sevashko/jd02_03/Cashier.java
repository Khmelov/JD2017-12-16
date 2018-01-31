package by.it.sevashko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier extends Thread {

    private int number;
    private final static AtomicInteger checkCount = new AtomicInteger(0);
    private static double total = 0;
    private double sum = 0;
    private final static Object lock = new Object();

    Cashier(int number){
        super(String.format("Касса №%d", number));
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "открылась");
        while (Dispatcher.allBuyersServiced()) {
            Buyer buyer = Dispatcher.getBuyer();
            if (buyer != null) {
                synchronized (buyer) {
                    try {
                        Thread.sleep(Helper.getRandom(2000, 5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getCheck(buyer));
                    buyer.notify();
                }
            }
            if (Dispatcher.getQueSize()/5+1 < Dispatcher.cashierCount()){
                break;
            }
        }
        Dispatcher.addToClosedCashiers(this.number);
        System.out.println(this + "закрылась");
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }

    private String getCheck(Buyer buyer){
        StringBuilder check = new StringBuilder();
        sum = 0;
        check.append(getLine(String.format("Чек №%d", checkCount.incrementAndGet())));
        check.append(getLine(this.toString()));
        check.append(getLine(buyer.toString()));
        check.append(getLine("Товары:"));
        for (String item : buyer.showBasket()){
            double price = Assortment.getPrice(item);
            check.append(getLine(String.format("%12s : %-10.2f", item, price)));
            sum += price;
        }
        check.append(getLine(String.format("Итого: %-10.2f", sum)));
        return check.toString();
    }

    private String getLine(String subLine){
        StringBuilder line = new StringBuilder();
        for (int column = 1; column <= 5; column++) {
            if (column == this.number){
                line.append("| ");
                line.append(String.format("%-27s", subLine));
            }
            else line.append(String.format("|%28s", " "));
        }
        if (subLine.startsWith("Итого")){
            line.append(String.format("| Размер очереди: %-3d | Выручка: %-8.2f|", Dispatcher.getQueSize(), addToTotal(sum)));
        }
        else {
            line.append(String.format("|%21s|%18s|", " ", " "));
        }
        line.append("\n");
        return line.toString();
    }

    private double addToTotal(double sum){
        synchronized (lock){
            return total += sum;
        }
    }
}
