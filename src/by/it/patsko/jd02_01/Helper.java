package by.it.patsko.jd02_01;

import java.util.Random;


 class Helper {
    private final static Random random=new Random();

     static int getRandom(int bound){
         return random.nextInt(bound);
     }
     static int getRandom(int start, int stop){
         return random.nextInt(stop-start+1);
     }
     static void sleep(int start, int stop){
         try {
             Thread.sleep(getRandom(start,stop));
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
}
