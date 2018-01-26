package by.it.patsko.jd02_01;

import java.util.Random;


class Helper {
    private final static Random random = new Random();

    static int getRandom(int bound) {
        return random.nextInt(bound);
    }

    static int getRandom(int start, int stop) {
        return random.nextInt(stop - start) + 1;
    }

    static void sleep(int start, int stop, boolean isPensioner) {
        try {
            Thread.sleep(isPensioner ? getRandom(start, stop) : (long) (getRandom(start, stop) * 1.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int getRandomCustomers() {
        int start = 0;
        if (MyStopwatch.getCurrentSecond() < 30) {
            if (Runner.queue.size() < MyStopwatch.getCurrentSecond() + 10) start++;
        } else {
            if (Runner.queue.size() <= 40 + (30 - MyStopwatch.getCurrentSecond())) start+=10;
        }
//        System.out.println("start "+start);
        return random.nextInt(3)+start;
    }
}
