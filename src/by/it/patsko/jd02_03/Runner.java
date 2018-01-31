package by.it.patsko.jd02_03;


import java.util.concurrent.*;

class Runner {

    public static void main(String[] args) {
        /*MyStopwatch stopwatch = new MyStopwatch();
        stopwatch.setDaemon(true);
        stopwatch.start();*/

        ExecutorService executors = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 6; i++) {
            Cashier c=new Cashier(new CountDownLatch((i-1)*5),i);
            executors.execute(c);
        }

        for (int minutes = 0; minutes < 2; minutes++) {
            for (int second = 0; second < 60; second++) {
                if (!Queue.planComplete()) {
                    int count = Helper.getRandomCustomers(second);
                    for (int i = 0; i <= count; i++) {
                        Buyer b = new Buyer(Queue.incNumOfAllCustomers());
                        b.start();
                    }
                }
            }
            if (Queue.planComplete()) break;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!Queue.allBuyerComplete()) {
            Buyer customer = Queue.readFirstQueue();
            if (customer != null) {
                try {
                    customer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Все вышли");
        Helper.sleep(100, 200);
        executors.shutdown();
        System.out.println("\nколичество покупателей в очереди:" + Queue.getQueueSize() +
                "\nколичество обслуженных покупателей:" + Queue.getNumOfServedCustomers() +
                "\nколичество покупателей всего:" + Queue.getNumOfAllCustomers() +
                "\nколичество свободных корзинок:" + (30 - Basket.numOfOccupiedBasket.intValue()));
    }
}
