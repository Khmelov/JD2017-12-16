package by.it.sevashko.jd02_02;


public class BuyersRunner extends Thread {

    @Override
    public void run(){
        for (int minute = 1; minute < 3; minute++) {
            for (int second = 1; second < 61; second++) {
                if (second < 31) {
                    if (Dispatcher.getQueSize() < second + 10){
                        for (int buyer = 0; buyer < 2; buyer++) {
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
                    if (Dispatcher.getQueSize() <= 70 - second) {
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
