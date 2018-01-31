package by.it.krasutski.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods extends HashMap<String, Double>  {

    private static Goods goods = new Goods() {
        {
            this.put("Хлеб", 1.0);
            this.put("Вода", 0.5);
            this.put("Соль", 0.8);
            this.put("Масло", 3.1);
        }
    };

    static String rndGoodName() {
        List<String> names = new ArrayList<>(goods.keySet());
        return names.get(Helper.getRandom(names.size()));
    }

    static int getSize(){
        return goods.size();
    }

    static Double getPrice(String name) {
        return goods.get(name);
    }
}
