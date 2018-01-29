package by.it.sevashko.jd02_02;

public class ShopRunner {

    public static void main(String[] args) {
        System.out.println("Магазин открылся");
        new BuyersRunner().start();
        for (int i = 0; i < 5; i++) {
            new Cashier().start();
        }
        while (!Dispatcher.AllBuyersServed()){
            Thread.yield();
        }
        System.out.println("Магазин закрылся");
    }
}
