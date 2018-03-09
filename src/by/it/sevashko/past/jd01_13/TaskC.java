package by.it.sevashko.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {

    private static Scanner sc;
    private static LinkedList<Double> numbers = new LinkedList<>();
    private static int exceptionCount = 0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        readData();
    }

    private static void readData(){
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            try {
                numbers.addFirst(Double.parseDouble(line));
            } catch (NumberFormatException exception){
                exceptionCount++;
                if (exceptionCount == 5) throw exception;
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println("Hello");
                }
                for (Double number : numbers) System.out.print(number + " ");
                System.out.println();
            }
        }
    }
}
