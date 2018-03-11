package by.it._tasks_.jd01_12;

import java.util.*;

public class TaskB2 {
    private static String process(ArrayList<String> peoples) {
        boolean delete = false;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (delete) it.remove();
                delete = !delete;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean delete = false;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (delete) it.remove();
                delete = !delete;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        LinkedList<String> a;
        a = new LinkedList<>(Arrays.asList("n1"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2", "n3"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2", "n3", "n4"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2", "n3", "n4", "n5"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2", "n3", "n4", "n5", "n6"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2", "n3", "n4", "n5", "n6", "n7"));
        System.out.println(a.toString() + " = " + process(a));
        a = new LinkedList<>(Arrays.asList("n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8"));
        System.out.println(a.toString() + " = " + process(a));

    }

}
