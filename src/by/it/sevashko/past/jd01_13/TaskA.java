package by.it.sevashko.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e){
            String nameOfException = e.getClass().getName();
            System.out.printf("name: %s\n", nameOfException);
            String nameOfCurrentClass = TaskA.class.getName();
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement one : trace){
                if (one.getClassName().equals(nameOfCurrentClass)){
                    System.out.println("class: " + nameOfCurrentClass);
                    System.out.println("line: " + one.getLineNumber());
                }
            }
        }
    }
}
