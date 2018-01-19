package by.it.krasutski.jd01_13;

import java.util.Scanner;

public class TaskB {

    private static double root = 0;
    private static double sumRoot = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.next()).equals("END")) {
            process(str);
        }
    }

    private static void process(String string) {
        try {
            double value = Double.parseDouble(string);
            if (value < 0) {
               throw new ArithmeticException();
            }
            root = Math.sqrt(value);
            sumRoot += value;
            double result = Math.sqrt(sumRoot);
            // У вас в задании опечатка или в тесте ошибка.
            // По заданию надо вывести в консоль сумму корней всех введенных чисел,
            // а по тесту считается корень суммы введенных чисел.
//            sumRoot += root;
            System.out.println(value);
//            System.out.println(root);
            System.out.println(result);
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

