package by.it.karpeichyk.jd02_03.demo3;

import java.util.Calendar;
import java.util.Random;

class Helper {
    static final long init=System.currentTimeMillis();
    static final Random random = new Random(init);

    static int fromTo(int from, int to) {
        //вычислим время ожидания
        int delta=to-from+1;
        int msWait=from+random.nextInt(delta);
        return msWait;
    }

    //чтобы не загромождать код вынесем try для sleep в свой отдельный метод
    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //текущая секунда (возможно метод пригодится для уровня C)
    static int getSecond(){
       return (Calendar.getInstance().get(Calendar.SECOND));
    }

}
