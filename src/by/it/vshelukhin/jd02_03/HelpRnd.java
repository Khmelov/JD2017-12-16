package by.it.vshelukhin.jd02_03;

import java.util.Random;

public class HelpRnd {

    static Random rnd = new Random();

    public static int getRnd(int a, int b){
        return rnd.nextInt(b-a)+a;
    }

    static int getNewBuyer(int second){
        int currentSec = second%60;
        int nTeor = currentSec < 30 ? currentSec + 10 : 40 + 30 - currentSec;
        int nPract = Shop.buyersAllInShop.size();
        if (nPract<nTeor) return nTeor-nPract;
        else return 0;
    }

    static int getNewCashier(int z){
        int nTeorCashier = (int) Math.ceil((double) z/5);
        if (nTeorCashier > 5) nTeorCashier = 5;
        return  nTeorCashier- Shop.getNumberAllCashierInWork();
    }
}
