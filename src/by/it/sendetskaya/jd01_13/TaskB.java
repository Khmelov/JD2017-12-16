package by.it.sendetskaya.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        String line;
        double sum=0;

        while (!(line = sc.nextLine()).equals("END")) {
            double result, data;
            try {
                data = Double.parseDouble(line.trim());
                sum+=data;
                if (sum<1) throw new ArithmeticException();
                result=Math.pow(sum,1./2);
                System.out.println("Текущее число= "+data+" , корень из суммы= "+result);

            } catch (NullPointerException|NumberFormatException|ArithmeticException e) {

                System.out.println("name: "+e.getClass().getName());//имя исключ

                String ourClass=TaskB.class.getName();
                StackTraceElement[]stackTraceElements=e.getStackTrace();
                for (StackTraceElement el: stackTraceElements) {
                    String className = el.getClassName();
                    int lineNumber = el.getLineNumber();
                    if (ourClass.equals(className)) {
                        System.out.println("class: " + className);
                        System.out.println("line: " + lineNumber);
                        System.out.println();
                        //break;
                    }
                }
            }
        }

    }
}
