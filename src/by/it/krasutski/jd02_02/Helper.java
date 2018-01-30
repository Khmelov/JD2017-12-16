package by.it.krasutski.jd02_02;

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
            Thread.sleep(isPensioner ? (long) (getRandom(start, stop) * 1.75) : getRandom(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep(int start, int stop) {
        try {
            Thread.sleep(getRandom(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
