package by.it.kozlov.jd01_11;

import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<Short> list=new SetC<>();
        for (int i = 0; i < 10; i++) {
            list.add((short) (i * 2));
        }
        System.out.println(list);
//        list.addAll(list2);
//        System.out.println(list);
    }
}
