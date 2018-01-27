package by.it.vshelukhin.jd02_01;

import java.util.Random;

public class HelpRnd {

    static Random rnd = new Random();

    public static int getRnd(int a, int b){
        return rnd.nextInt(b-a)+a;
    }

    static int getNewBuyer(int second){
        int currentSec = second%60;
        int nTeor = currentSec < 30 ? currentSec + 10 : 40 + 30 - currentSec;
        int nPract = Shop.BuyersAll.size();
        if (nPract<nTeor) return nTeor-nPract;
        else return 0;
    }
}
