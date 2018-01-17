package by.it.vshelukhin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.lang.Math.*;

public class TaskA1 {
    List<Integer> balls = new ArrayList<>();

    void clearBad (List<Integer> grades){
        Iterator it = grades.iterator();
        while (it.hasNext()){
            if ((int)it.next() < 4) it.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 taskA = new TaskA1();
        for (int i = 0; i < 21; i++) {
            taskA.balls.add((int)(random()*11));
        }
        System.out.println(taskA.balls);
        taskA.clearBad(taskA.balls);
        System.out.println(taskA.balls);

    }
}
