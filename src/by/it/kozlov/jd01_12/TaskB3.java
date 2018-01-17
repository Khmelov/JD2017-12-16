package by.it.kozlov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        Timer time = new Timer();
        int[] expectedRes = {1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15, 1};
        ArrayList<String> arr = new ArrayList<>();
        LinkedList<String> link = new LinkedList<>();
        for (int i = 1; i <= expectedRes.length; i++) {
            arr.add("n" + i);
            link.add("n" + i);
        }
        System.out.println(process(arr) + time);
        System.out.println(process(link) + time);
    }

    public static String process(ArrayList<String> peoples) {

        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            boolean test = false;
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
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            boolean test = false;
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

    public static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return " Прошло " + Delta.toString() + " микросекунд.";
        }
    }
}
