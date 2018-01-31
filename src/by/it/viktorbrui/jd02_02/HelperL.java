package by.it.viktorbrui.jd02_02;

import java.util.Random;

public class HelperL {
    private final static Random random = new Random();
    static int getRandom (int bound){
        return random.nextInt(bound);
    }
    private static int getRandom (int start, int stop){
        return start+random.nextInt(stop-start);
    }
    static void sleep (int start,int stop){
        try{
            Thread.sleep(HelperL.getRandom(start,stop));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
