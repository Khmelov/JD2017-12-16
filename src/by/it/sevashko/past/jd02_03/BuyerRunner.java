package by.it.sevashko.jd02_03;

public class BuyerRunner extends Thread {

    @Override
    public void run() {
        for (int minute = 1; minute <= 2; minute++) {
            for (int second = 1; second <= 60; second++) {
                int buyersInShop = Dispatcher.getBuyersCount();
                if (second <= 30) {
                    if (buyersInShop < second +10) {
                        for (int i = 0; i < 4; i++) {
                            if (Dispatcher.planComplete()) break;  //ВСЕГО обслуживается до 100 покупателей
                            new Buyer(Dispatcher.getNumber()).start();
                        }
                    } else {
                        for (int i = 0; i < Helper.getRandom(0, 2); i++) {
                            if (Dispatcher.planComplete()) break; //ВСЕГО обслуживается до 100 покупателей
                            new Buyer(Dispatcher.getNumber()).start();
                        }
                    }
                } else {
                    if (buyersInShop < 70 + second){
                        for (int i = 0; i < Helper.getRandom(0, 2); i++) {
                            if (Dispatcher.planComplete()) break; //ВСЕГО обслуживается до 100 покупателей
                            new Buyer(Dispatcher.getNumber()).start();
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Dispatcher.planComplete()) break; //ВСЕГО обслуживается до 100 покупателей
        }
    }
}
