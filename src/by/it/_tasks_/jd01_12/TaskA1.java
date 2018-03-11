package by.it._tasks_.jd01_12;

import java.util.List;

public class TaskA1 {
    void clearBad(List<Integer> grades) {
        for (Integer i = 0; i < 4; i++) {
            for (;grades.remove(i););
        }

    }
}
