package by.it.patsko.jd02_01;

import java.util.LinkedList;
import java.util.Queue;

class Runner {
    static Queue<Buyer> queue = new LinkedList<>();
    private static int countBuyer = 0;

    public static void main(String[] args) throws InterruptedException {
        MyStopwatch stopwatch = new MyStopwatch();
        stopwatch.setDaemon(true);
        stopwatch.start();
        for (int minutes = 0; minutes < 2; minutes++) {
            for (int second = 0; second < 60; second++) {
                int count = Helper.getRandomCustomers();
//            int count = Helper.getRandom(3);
                for (int i = 0; i <= count; i++) {
                    Buyer b = new Buyer(++countBuyer);
                    b.start();
                    queue.add(b);
                }
                Thread.sleep(100);
            }
        }
        while (queue.size() > 0) {
            for (Buyer buyer : queue) {
                try {
                    buyer.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Все вышли");
    }
}
