package by.it.pozdeev.jd01_13;

import java.util.*;

public class TaskC {
    private static Scanner scanner;
    private static Deque<Double> deque = new ArrayDeque<>();
    private static int count = 0;


    public static void main(String[] args) throws Exception,AssertionError {
        scanner = new Scanner(System.in);
        while (true) readData();
    }

    static void readData() throws Exception,AssertionError {

        try {
            deque.add(Double.parseDouble(scanner.nextLine()));
        } catch (NumberFormatException e) {
            if (count == 5) throw new Exception();
            count++;
            Thread.sleep(100);
            Iterator it=deque.descendingIterator();
            System.out.print("\n");
            while (it.hasNext()) System.out.print(it.next()+" ");
            System.out.println();

        }
    }

}


