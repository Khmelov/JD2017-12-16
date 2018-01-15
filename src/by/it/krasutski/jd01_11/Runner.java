package by.it.krasutski.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(1,"12");
        System.out.println(list);
        List<String> second = new ListB<>();
        second.add("lol");
        second.addAll(list);
        System.out.println(second);
    }
}
