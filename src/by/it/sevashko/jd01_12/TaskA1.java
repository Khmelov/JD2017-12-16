package by.it.sevashko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            instance.marks.add((int) (Math.random()*11));
        }
        System.out.println(instance);
        instance.clearBad(instance.marks);
        System.out.println(instance);
    }

    @Override
    public String toString() {
        return marks.toString();
    }

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
    }
}
