package by.it.kozlov.jd01_13;

import java.util.Scanner;

public class TaskB {
    static double sqrt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.next()).equals("end")) {
            pars(str);
        }
    }

    public static void pars(String string) {
        try {
            double value = Double.parseDouble(string);
            if (value < 0) new NumberFormatException();
            sqrt = Math.sqrt(sqrt + value);
            System.out.println(value);
            System.out.println(sqrt);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("name: " + e.getClass().getName());
            String ourName = TaskB.class.getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                if (ourName.equals(className)) {
                    System.out.println("class: " + className);
                    System.out.println("line: " + lineNumber);
                    break;
                }
            }
        }
    }
}
