package by.it.kozlov.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListB<>();
        List<String> list2=new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");
        System.out.println(list);
        list.addAll(list2);
        System.out.println(list);
    }
}
