package by.it.vshelukhin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        int n = 5;

        ArrayList<String> peopleArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            peopleArray.add(String.valueOf(i+1));
        }
        System.out.println(process(peopleArray));

        ArrayList<String> peopleLinked = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            peopleLinked.add(String.valueOf(i+1));
        }
        System.out.println(process(peopleLinked));
    }

    static String process (ArrayList<String> l){
        System.out.println(l);
        boolean flag = false;
        while (l.size() != 1){
            Iterator it = l.iterator();
            while (it.hasNext()) {
                if (it.hasNext()) it.next();
                if (flag) {
                    it.remove();
                    System.out.println(l);
                    flag = !flag;
                } else {
                    flag = !flag;
                }
            }
        }
        return l.get(0);
    }

    static String process (LinkedList<String> l){
        System.out.println(l);
        boolean flag = false;
        while (l.size() != 1){
            Iterator it = l.iterator();
            while (it.hasNext()) {
                if (it.hasNext()) it.next();
                if (flag) {
                    it.remove();
                    System.out.println(l);
                    flag = !flag;
                } else {
                    flag = !flag;
                }
            }
        }
        return l.get(0);
    }
}
