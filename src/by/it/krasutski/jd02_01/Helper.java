package by.it.krasutski.jd02_01;

import java.util.Random;

public class Helper {

    private final static Random RANDOM = new Random();

    static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }

    static int getRandom(int start, int stop) {
        return start + RANDOM.nextInt(stop - start);
    }

    static void sleep(int start, int stop) {
        try {
            Thread.sleep(Helper.getRandom(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
