package by.it.viktorbrui.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodsL extends HashMap<String,Double> {
   private static GoodsL goodsL=new GoodsL(){
       {
           this.put("Хлеб",1.2);
           this.put("Батон",0.9);
           this.put("Молоко",1.5);
           this.put("Сыр",2.4);
           this.put("Крупа",1.3);
           this.put("Макароны",2.0);
           this.put("Масло",3.1);
           this.put("Вода",1.1);
           this.put("Крекеры",1.7);
           this.put("Гамбургер",2.1);
           this.put("Пельмени",2.6);
           this.put("Пивко",2.3);

       }
   };
   private GoodsL(){
   }
   static Double getPrice(String name){
       return goodsL.get(name);
     //  Double a = Double.parseDouble();
   }
   static String randomGoodName(){
       List<String> names = new ArrayList<>(goodsL.keySet());
       return names.get(HelperL.getRandom(names.size()));
   }
}
