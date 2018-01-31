package by.it.sevashko.jd02_03;

import java.util.HashMap;
import java.util.Set;

public class Assortment{

    private static HashMap<String, Double> assortment = new HashMap<>();

    static {
        assortment.put("Хлеб", 1.0);
        assortment.put("Вода", 0.5);
        assortment.put("Соль", 0.8);
        assortment.put("Масло", 3.1);
    }

    static Set<String> getProducts(){
        return assortment.keySet();
    }

    static int getSize(){
        return assortment.size();
    }

    static Double getPrice(String name){
        return assortment.get(name);
    }
}
