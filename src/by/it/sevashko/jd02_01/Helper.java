package by.it.sevashko.jd02_01;

import java.util.Random;

public class Helper {

    private static Random random = new Random();

    static int getRandom(int bound){
        return random.nextInt(bound);
    }

    static int getRandom(int start, int end){
        return start + random.nextInt(end - start);
    }

    static void sleep(int start, int stop){
        try {
            Thread.sleep(getRandom(start,stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
