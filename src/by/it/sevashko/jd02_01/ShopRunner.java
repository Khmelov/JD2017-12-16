package by.it.sevashko.jd02_01;


public class ShopRunner {

    public static void main(String[] args) {
        for (int second = 0; second < 120; second++) {
            int buyerNumber = Helper.getRandom(2);
            for (int buyer = 0; buyer <= buyerNumber; buyer++) {
                Buyer b = new Buyer(buyer+1);
                b.start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
