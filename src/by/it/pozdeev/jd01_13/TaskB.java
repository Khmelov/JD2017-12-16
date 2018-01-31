package by.it.pozdeev.jd01_13;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        Double sum = 0.0;
        Double it;
        try {
            while (!(str = sc.next()).equals("END")) {
                if ((it = Double.parseDouble(str))<0)throw new ArithmeticException();
                sum+=it;
                System.out.println("it=" + it + "\n" + "sum=" + Math.sqrt(sum));
            }
        } catch (NullPointerException | NumberFormatException | ArithmeticException e) {
            System.out.println("name:" + e.getClass().getName());
            String ourName = TaskB.class.getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                String classname = element.getClassName();
                int linenumber = element.getLineNumber();
                if (ourName.equals(classname)) {
                    System.out.println("class:" + classname);
                    System.out.println("line:" + linenumber);
                    break;
                }
            }
        }
    }
}

