package by.it.sevashko.jd02_02;

import java.util.LinkedList;

public class Cashier extends Thread{

    private int number;
    private static LinkedList<Integer> numbers = new LinkedList<>();

    static {
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);
        numbers.addLast(4);
        numbers.addLast(5);
    }

    Cashier(){
        super("Касса №" + numbers.peekFirst());
        this.number = numbers.pollFirst();
    }

    @Override
    public void run() {
        System.out.println(this + "открылась");
        while (Dispatcher.AllBuyersServed()) {
            Buyer buyer = Dispatcher.getBuyer();
            Helper.sleep(2000, 5000);
            if (buyer != null) {
                synchronized (buyer) {
                    double sum = 0;
                    StringBuilder check = new StringBuilder();
                    check.append(String.format("Чек %s\n", buyer));
                    for (String product : buyer.showChosenProducts()){
                        double price = Assortment.getPrice(product);
                        sum += price;
                        check.append(String.format("%6s : %-6.2f\n", product, price));
                    }
                    check.append(String.format("Сумма к оплате: %-6.2f\n", sum));
                    System.out.println(check);
                    buyer.notify();
                }
            }
            if (Dispatcher.removeFromWorkingCashiers(this)){
                System.out.println(this + "закрылась");
                synchronized (Cashier.class) {
                    numbers.addFirst(number);
                }
                break;
            }
        }
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }
}
