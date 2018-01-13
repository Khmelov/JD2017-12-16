package by.it.patsko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        List<Integer> list=new ArrayList<>();
        List<String> list=new ListA<>();
        list.add("One");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
