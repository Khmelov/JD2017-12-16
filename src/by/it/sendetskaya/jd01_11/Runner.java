package by.it.sendetskaya.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println("------------------------");

        List<String> listAdd=new ArrayList<>();
        listAdd.add("1");
        listAdd.add("2");
        List<String >listCont=new ArrayList<>();
        listCont.add("1");
        listCont.add("ghjj");

        List<String> listB=new ListB<>();
        listB.add("one");
        listB.add("two");
        listB.add("three");
        System.out.println(listB);
        listB.remove(1);
        System.out.println(listB);
        System.out.println(listB.get(2));
        listB.add(1,null);
        System.out.println(listB);
        listB.set(1,"four");
        System.out.println(listB);
        listB.addAll(listAdd);
        System.out.println(listB);
        System.out.println("------------------------");

        Set<String> listC=new SetC<>();
        listC.add("three");
        listC.add("two");
        listC.add("one");
        listC.add("two");
        System.out.println(listC);
        if (listC.contains("one"))System.out.println("one is contained in SetC");
        else System.out.println("one isn't");
        listC.remove("three");
        System.out.println(listC);
        listC.addAll(listAdd);
        System.out.println(listC);
        if (listC.containsAll(listCont))System.out.println("list is contained in SetC");
        else System.out.println("list isn't");
        listC.removeAll(listAdd);
        System.out.println(listC);
        System.out.println("------------------------");

        List<Integer> listAddInt=new ArrayList<>();
        listAddInt.add(5);
        listAddInt.add(2);
        listAddInt.add(null);

        Set<Integer>listCInt=new SetC<>();
        listCInt.add(5);
        listCInt.add(0);
        listCInt.add(123);
        System.out.println(listCInt);
        //listCInt.remove(0);
        System.out.println(listCInt);
        listCInt.addAll(listAddInt);
        System.out.println(listCInt);
        listCInt.removeAll(listAddInt);
        System.out.println(listCInt);
        listCInt.clear();
        System.out.println(listCInt);



    }
}
