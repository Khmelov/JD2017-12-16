package by.it.kozlov.jd01_13;

import java.util.*;

public class TaskC {
    static Deque<Double> list = new ArrayDeque<>();
    static int counter = 0;
    static Scanner sc;

    public static void main(String[] args) throws Exception, AssertionError {
        sc = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    static void readData() throws Exception, AssertionError {
        try {
            list.addFirst(Double.parseDouble(sc.next()));
        } catch (NumberFormatException e) {
            if (counter == 5) throw new Exception();
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
