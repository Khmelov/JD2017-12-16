package by.it.patsko.jd02_03;


import java.util.concurrent.*;

class Runner {

    public static void main(String[] args) {
       /* MyStopwatch stopwatch = new MyStopwatch();
        stopwatch.setDaemon(true);
        stopwatch.start();*/


        ExecutorService executors = Executors.newFixedThreadPool(5);


        for (int minutes = 0; minutes < 2; minutes++) {
            for (int second = 0; second < 60; second++) {
                if (!Queue.planComplete()) {

                    int numOfCashier=Cashier.getNumOfCashier();
                    int queueSize=Queue.getQueueSize();
                    if ( numOfCashier < 5 && queueSize >= numOfCashier * 5) {
                            Cashier c = new Cashier(Cashier.openCashier());
                            executors.execute(c);

                    }

                    int count = Helper.getRandomCustomers(second);
                    for (int i = 0; i <= count; i++) {
                        Buyer b = new Buyer(Queue.incNumOfAllCustomers());
                        b.start();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Queue.planComplete()) break;


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
        /*for (ExecutorService executor : executors) {
            executor.shutdown();
        }*/
        executors.shutdown();

        System.out.println("\nколичество покупателей в очереди:" + Queue.getQueueSize() +
                "\nколичество обслуженных покупателей:" + Queue.getNumOfServedCustomers() +
                "\nколичество покупателей всего:" + Queue.getNumOfAllCustomers() +
                "\nколичество свободных корзинок:" + (30 - Basket.numOfOccupiedBasket.intValue()));
    }
}
