package by.it.sevashko.jd02_02;

public class Cashier extends Thread{

    @Override
    public void run() {
        while (!Dispatcher.AllBuyersServed()) {
            Buyer buyer = Dispatcher.getBuyer();
            Helper.sleep(2000, 5000);
            if (buyer != null) {
                synchronized (buyer) {
                    System.out.println(buyer + "обслужен");
                    buyer.notify();
                }
            }
        }
    }


}
