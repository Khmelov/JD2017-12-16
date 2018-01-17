package by.it.vshelukhin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public class TaskB3 {
    public static void main(String[] args) {

        int n = 4096;

        ArrayList<String> peopleArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            peopleArray.add(String.valueOf(i+1));
        }
        long timeArray = System.nanoTime();
        System.out.println("Из peopleArray остался человек номер "+process(peopleArray)+". Вычислено за "+(System.nanoTime()-timeArray)+" наносекунд.");

        ArrayList<String> peopleLinked = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            peopleLinked.add(String.valueOf(i+1));
        }
        long timeLinked = System.nanoTime();
        System.out.println("Из peopleLinked остался человек номер "+process(peopleLinked)+". Вычислено за "+(System.nanoTime()-timeLinked)+" наносекунд.");
    }

    static String process (ArrayList<String> l){
        boolean flag = false;
        while (l.size() != 1){
            Iterator it = l.iterator();
            while (it.hasNext()) {
                if (it.hasNext()) it.next();
                if (flag) {
                    it.remove();
                    flag = !flag;
                } else {
                    flag = !flag;
                }
            }
        }
        return l.get(0);
    }

    static String process (LinkedList<String> l){
        boolean flag = false;
        while (l.size() != 1){
            Iterator it = l.iterator();
            while (it.hasNext()) {
                if (it.hasNext()) it.next();
                if (flag) {
                    it.remove();
                    flag = !flag;
                } else {
                    flag = !flag;
                }
            }
        }
        return l.get(0);
    }
}
