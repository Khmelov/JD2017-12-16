package by.it.patsko.jd02_01;

import java.util.Random;


class Helper {
    private final static Random random = new Random();

    static int startRandCustomers =0;

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
        if (MyStopwatch.getCurrentSecond() < 30) {
            if (Runner.queue.size() < MyStopwatch.getCurrentSecond() + 10) startRandCustomers++;
            else if(Runner.queue.size()>25) startRandCustomers -=2;
            else if(Runner.queue.size()>30) startRandCustomers -=3;
            else startRandCustomers -=2;
        } else {
            if (Runner.queue.size() <= 40 + (30 - MyStopwatch.getCurrentSecond())) startRandCustomers++;
            else if(Runner.queue.size()>=35) startRandCustomers -=4;
            else if(Runner.queue.size()>=40) startRandCustomers -=5;
            else startRandCustomers -=2;
        }
        return  startRandCustomers;
    }
}
