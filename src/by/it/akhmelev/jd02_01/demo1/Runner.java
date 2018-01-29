package by.it.akhmelev.jd02_01.demo1;

import java.util.ArrayDeque;
import java.util.Queue;

class Runner {

    //общий счетчик созданных покупателей
    private static int countBuyers = 0;

    //так можно создать очередь для покупателей. Пока обычную.
    static Queue<Buyer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws InterruptedException {
        while (countBuyers < 10) {
            Thread.sleep(1000); //ожидание в 1 секунду
            int count = Rnd.fromTo(0, 2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers < 11) {
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                    System.out.println("В магазине: " + queue.size() + " человек.");
                }
            }
        }
        while (queue.size() > 0) {
            queue.element().join();
        }
        System.out.println("В магазине: " + queue.size() + " человек.");
    }
}
