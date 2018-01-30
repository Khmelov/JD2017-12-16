package by.it.viktorbrui.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    void clearBad(List<Integer> grades) {
        Iterator<Integer> it = grades.iterator();
        while (it.hasNext()) {
            while (it.hasNext() && it.next() < 4) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            instance.grades.add((int) Math.round(Math.random() * 10));
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }
}
