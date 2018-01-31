package by.it.pozdeev.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> groupArray = new ArrayList<>();
        LinkedList<String> groupLinked = new LinkedList<>();
        int N = 4;//(int) Math.random() * 4;
        for (int i = 1; i <= N; i++) {
            groupArray.add("n" + i);
            groupLinked.add("n" + i);
        }
        System.out.println(process(groupArray));
        System.out.println(process(groupLinked));


    }

    static String process(ArrayList<String> people) {
        Iterator it;
        int i = 0;
        while ((people.size() != 1)) {

            it = people.iterator();
            while (it.hasNext()) {
                switch (i) {
                    case 1: {
                        it.next();
                        it.remove();
                        i = 0;
                        break;
                    }
                    case 0: {
                        it.next();
                        i = 1;
                        break;
                    }
                }
            }
        }
        return people.get(0);
    }

    static String process(LinkedList<String> people) {
        Iterator it;
        int i = 0;
        while ((people.size() != 1)) {

            it = people.iterator();
            while (it.hasNext()) {
                switch (i) {
                    case 1: {
                        it.next();
                        it.remove();
                        i = 0;
                        break;
                    }
                    case 0: {
                        it.next();
                        i = 1;
                        break;
                    }
                }
            }
        }
        return people.get(0);
    }
}