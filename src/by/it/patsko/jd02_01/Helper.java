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
        int num, size=Runner.queue.size(),result=0;
        /*if (MyStopwatch.getCurrentSecond() < 30) {
            while ( size< MyStopwatch.getCurrentSecond() + 10) {
                num = getRandom(3);
                result += num;
                size += num;
            }
        } else {
            while (size <= 40 + (30 - MyStopwatch.getCurrentSecond())){
                num = getRandom(3);
                result += num;
                size += num;
            }
        }*/
        if (MyStopwatch.getCurrentSecond() < 30) {
            while ( result+Runner.queue.size()< MyStopwatch.getCurrentSecond() + 10) {
                result += getRandom(3);
            }
        } else {
            while (result+Runner.queue.size() <= 40 + (30 - MyStopwatch.getCurrentSecond())){
                result += getRandom(3);
            }
        }

        return result;
    }
}
