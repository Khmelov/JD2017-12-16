package by.it.pozdeev.jd01_12;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> groupArray = new ArrayList<>();
        LinkedList<String> groupLinked = new LinkedList<>();
        int N = 4096;//(int) Math.random() * 4;
        for (int i = 1; i <= N; i++) {
            groupArray.add("n" + i);
            groupLinked.add("n" + i);
        }
        long t=System.nanoTime();
        System.out.println(process(groupArray));
        long dtSlow = (System.nanoTime() - t) / 1000;
        System.out.println("slow dt=" + dtSlow);
        t=System.nanoTime();
        System.out.println(process(groupLinked));
        long dtFast = (System.nanoTime() - t) / 1000;
        System.out.println("fast dt=" + dtFast);


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