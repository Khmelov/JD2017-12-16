package by.it.sendetskaya.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NullPointerException|NumberFormatException e) {
            System.out.println("name: "+e.getClass().getName());//имя исключ

            String ourClass=TaskA.class.getName();
            StackTraceElement[]stackTraceElements=e.getStackTrace();
            for (StackTraceElement el: stackTraceElements) {
                String className=el.getClassName();
                int lineNumber=el.getLineNumber();
                if(ourClass.equals(className)) {
                    System.out.println("class: " + className);
                    System.out.println("line: " + lineNumber);
                    System.out.println();
                    break;
                }
            }
        }
    }

}
