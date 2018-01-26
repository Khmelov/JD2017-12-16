package by.it.vshelukhin.jd02_01;

import java.util.*;

public class Kassa {

    static Map<Buyer,Double> history = new HashMap<>(){
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
