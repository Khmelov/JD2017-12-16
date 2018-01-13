package by.it.kozlov.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListA<>();
        list.add("one");
        list.add("one");
        list.add("one");
        list.add("one");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
