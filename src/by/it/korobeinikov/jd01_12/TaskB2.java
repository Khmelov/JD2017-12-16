package by.it.korobeinikov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        int[] expectedRes = {1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15};
        ArrayList<String> arr = new ArrayList<>();
        LinkedList<String> link = new LinkedList<>();
        for (int i = 1; i <= expectedRes.length; i++) {
            arr.add("n" + i);
            link.add("n" + i);
        }
        System.out.println(process(arr));
        System.out.println(process(link));
    }

    public static String process(ArrayList<String> peoples) {
        boolean test = false;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (test) {
                    iterator.remove();
                    test = false;
                } else test = true;
            }
        }
        return peoples.get(0);
    }

    public static String process(LinkedList<String> peoples) {
        boolean test = false;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (test) {
                    iterator.remove();
                    test = false;
                } else test = true;
            }
        }
        return peoples.getFirst();
    }
}

