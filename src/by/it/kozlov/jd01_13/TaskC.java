package by.it.kozlov.jd01_13;

import java.util.*;

public class TaskC {
    static Deque<Double> list = new ArrayDeque<>();
    static int counter = 0;

    public static void main(String[] args) throws Exception, AssertionError {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            readData(sc.next());
        }
    }

    static void readData(String str) throws Exception, AssertionError {
        try {
            list.addFirst(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            if (counter == 4) throw new Exception();
            counter++;
            Thread.sleep(100);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }
}
