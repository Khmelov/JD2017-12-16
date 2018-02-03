package by.it.karpeichyk.jd01_11;

import java.util.*;

/**
 * Created by user on 15.01.2018.
 */
public class HomeWork {
    public static void main(String[] args) {
      /*  ArrayList<String> list =new ArrayList<>();
        list.add("help");
        list.add("me");
        list.add("please");
        list.add("bla-bla-bla");
        System.out.println(list);
        list.add(4,"pretty");
        list.remove(2);
        System.out.println(list);
        list.set(0,"dog");
        System.out.println(list);
        Object obj=new Object();
        obj="you";
        int ints = list.indexOf(obj);
       System.out.println(ints);
        List<String> strings = list.subList(0, 2);
        System.out.println(strings);
        list.get(2);
        System.out.println(list);*/
        HashMap<String,Integer>  hm = new HashMap<>(2);{
            {
                hm.put("пряник", 3);
                hm.put("молоко", 2);
                hm.put("хлеб", 6);
                hm.put("сыр", 8);

            }
        }

        System.out.println(hm);
        hm.put("молоко",5);
       // System.out.println(hm+"after change");
        Integer a = hm.get("сыр");
        System.out.println(a+"found about Interger key");
       //вывод хеш таблицы
        Set<Map.Entry<String,Integer>> vbn = hm.entrySet();
        System.out.println(vbn);
        Iterator<Map.Entry<String,Integer>> v = vbn.iterator();
        while (v.hasNext()){
            Map.Entry<String,Integer> me= v.next();
            System.out.println(me.getKey()+":"+me.getValue());
        }
        Set<Integer> val= new HashSet<>(hm.values());
        System.out.println(val);
    }

}
