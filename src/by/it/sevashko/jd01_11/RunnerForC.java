package by.it.sevashko.jd01_11;

import java.util.HashSet;

public class RunnerForC {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(5);
        hashSet.add(23);
        hashSet.add(3);
        hashSet.add(96);
        System.out.println(hashSet);

        SetC<Integer> set = new SetC<>();
        set.add(4);
        set.add(5);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set);

        SetC<Integer> set1 = new SetC<>();
        set1.add(6);
        set1.add(7);
        System.out.println(set.containsAll(set1));
        set.addAll(set1);
        System.out.println(set);
    }
}
