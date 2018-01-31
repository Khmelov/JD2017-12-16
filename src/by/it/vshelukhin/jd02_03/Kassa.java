package by.it.vshelukhin.jd02_03;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Kassa {

    static ConcurrentMap<Buyer,Double> history = new ConcurrentHashMap<Buyer,Double>(){
        @Override
        public String toString() {
            return super.toString().replace(", ", "\n");
        }
    };

    static void addHist(Buyer buyer, Double price){
        history.put(buyer,price);
    }

    static double getCurrentAllMoney(){
        double sum = 0.0;
        Collection<Double> money = history.values();
        Iterator<Double> it = money.iterator();
        while (it.hasNext()){
            sum = sum + it.next();
        }
        return sum;
    }

    static int getNumberAllBuyers(){
        return history.size();
    }
}
