package by.it.sevashko.jd02_02;

import java.util.LinkedList;

public class Cashier extends Thread{

    private int number;
    private static LinkedList<Integer> numbers = new LinkedList<>();
    private static double total = 0;

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
                    check.append(getLine(String.format("Чек %s", buyer))).append("\n");
                    for (String product : buyer.showChosenProducts()){
                        double price = Assortment.getPrice(product);
                        sum += price;
                        check.append(getLine(String.format("%6s : %-6.2f", product, price))).append("\n");
                    }
                    check.append(getLine(String.format("Сумма к оплате: %-6.2f", sum)));
                    check.append(String.format("Размер очереди: %-3d      Выручка: %-6.2f", Dispatcher.getQueSize(), addToTotal(sum)));
                    System.out.println(check);
                    buyer.notify();
                }
            } else continue;
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

    private String getIndent(){
        StringBuilder indent = new StringBuilder();
            for (int j = 0; j < 30; j++) {
                indent.append(" ");
            }
        return indent.toString();
    }

    private String getLine(String subLine){
        String indent = getIndent();
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            if (i == number) {
                line.append(String.format("%-30s", subLine));
            }
            else {
                line.append(getIndent());
            }
        }
        return line.toString();
    }

    static double getTotal(){
        synchronized (Cashier.class){
            return total;
        }
    }

    private double addToTotal(double plus){
        synchronized (Cashier.class){
           return total += plus;
        }
    }
}
