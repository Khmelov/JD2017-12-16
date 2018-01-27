package by.it.vshelukhin.jd02_01;

import java.util.*;

public class Goods extends HashMap<String, Double> {

   static Goods goods = new Goods(){
       {
            this.put("Молоко",1.05);
            this.put("Хлеб",0.45);
            this.put("Колбаса",6.85);
            this.put("Пиво",2.15);
            this.put("Водка",7.55);

        }
    };

   public static String getRndGood(){
       Set<String> ks = goods.keySet();
       List<String> l = new ArrayList<>(ks);
       return l.get(HelpRnd.getRnd(0,l.size()));
   }

   public static Double getPrice (String name){
       return goods.get(name);
   }
}
