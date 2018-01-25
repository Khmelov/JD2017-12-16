package by.it.sendetskaya.jd02_01;

import java.util.Random;

public class Helper {
    private final static Random random=new Random();

    static int getRandom(int max)
    {
        return random.nextInt(max);
    }

    static int getRandom(int start, int stop)
    {
        return start+random.nextInt(stop-start+1);
    }

    static void sleep(int start, int stop) {
        try {
            Thread.sleep(start,stop);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
