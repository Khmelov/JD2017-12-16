package by.it._tasks_.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        List<Double> num=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str=scanner.nextLine();
            if (str.equals("END")) break;
            try {
                num.add(Double.parseDouble(str));
                double root=0;
                for (Double value : num) {
                    root+=value;
                }
                root=Math.sqrt(root);
                if (Double.isNaN(root))
                    throw new ArithmeticException("root(negative)");
                System.out.println(root);
            } catch (Exception e) {
                StackTraceElement[] stack = e.getStackTrace();
                for (StackTraceElement element : stack) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String numline = "  line:" + element.getLineNumber();
                        String clname = " class:" + element.getClassName();
                        System.out.println(e.getClass().getName() + " " + numline + clname);
                        break;
                    }
                }
            }
        }
    }
}
