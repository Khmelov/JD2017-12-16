package by.it.vshelukhin.jd02_02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Kassa {

    static Map<Buyer,Double> history = new HashMap<Buyer,Double>(){
        @Override
        public String toString() {
            return super.toString().replace(", ", "\n");
        }
    };

    static synchronized void addHist(Buyer buyer, Double price){
        history.put(buyer,price);
    }

    static synchronized double getCurrentAllMoney(){
        double sum = 0.0;
        Collection<Double> money = history.values();
        Iterator<Double> it = money.iterator();
        while (it.hasNext()){
            sum = sum + it.next();
        }
        return sum;
    }

    static synchronized int getNumberAllBuyers(){
        return history.size();
    }
}
