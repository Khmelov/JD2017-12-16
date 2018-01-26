package by.it.kozlov.jd02_01;

import java.util.Random;

public class Helper {
    private final static Random random = new Random();

    static int getRandom(int bound) {
        return random.nextInt(bound);
    }

    private static int getRandom(int start, int stop) {
        return start + random.nextInt(stop - start);
    }

    static void sleep(int start, int stop) {
        try {
            Thread.sleep(Helper.getRandom(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
