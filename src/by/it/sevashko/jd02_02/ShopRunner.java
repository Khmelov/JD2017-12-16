package by.it.sevashko.jd02_02;

public class ShopRunner {

    public static void main(String[] args) {
        System.out.println("Магазин открылся");
        new BuyersRunner().start();

        while (Dispatcher.AllBuyersServed()){
            if (Dispatcher.getQueSize()/5+1 <= Dispatcher.getCashierCount()) {
                Thread.yield();
            }
            else {
                if (Dispatcher.getCashierCount() < 5) {
                    Cashier cashier = new Cashier();
                    cashier.start();
                    Dispatcher.addToCashierSet(cashier);
                }
            }
        }
        System.out.printf("Общая выручка : %-7.2f\n", Cashier.getTotal());
        System.out.println("Магазин закрылся");
    }

}
