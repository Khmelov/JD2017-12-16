package by.it.sevashko.jd02_01;


public class ShopRunner {

    public static void main(String[] args) {
        for (int minute = 1; minute < 3; minute++) {
            for (int second = 1; second < 61; second++) {
                if (second < 31) {
                    if (Dispatcher.getCurrentBuyerNumber() < second + 10){
                        for (int buyer = 0; buyer <= Helper.getRandom(1,3); buyer++) {
                            Buyer b = new Buyer(Dispatcher.getBuyerNumber());
                            b.start();
                        }
                    }
                    else {
                        int buyerNumber = Helper.getRandom(2);
                        for (int buyer = 0; buyer <= buyerNumber; buyer++) {
                            Buyer b = new Buyer(Dispatcher.getBuyerNumber());
                            b.start();
                        }
                    }
                }
                else {
                    if (Dispatcher.getCurrentBuyerNumber() <= 70 - second) {
                        int buyerNumber = Helper.getRandom(2);
                        for (int buyer = 0; buyer <= buyerNumber; buyer++) {
                            Buyer b = new Buyer(Dispatcher.getBuyerNumber());
                            b.start();
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
