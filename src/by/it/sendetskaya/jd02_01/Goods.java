package by.it.sendetskaya.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Goods extends HashMap<String,Double>{

    private static Goods goods= new Goods() {
        {
            this.put("Хлеб", 1.00);
            this.put("Вода", 2.00);
            this.put("Мука", 3.00);
            this.put("Соль", 1.00);
            this.put("Молоко", 1.50);
        }
    };

    private Goods()
    {

    }

    static Double getPrice(String name)
    {
        return goods.get(name);
    }

    static String getGoodName()
    {
        List<String> names=new ArrayList<>(goods.keySet());
        return names.get(Helper.getRandom(names.size()));
    }
}
