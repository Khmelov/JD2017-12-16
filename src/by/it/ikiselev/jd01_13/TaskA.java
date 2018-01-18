package by.it.ikiselev.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
        }
        catch (NullPointerException|NumberFormatException e){
            String name=e.getClass().getName();
            System.out.println("NullPointerException");
            System.out.println("name: "+name);
            String ourName=TaskA.class.getName();
            StackTraceElement[] stackTraceElements=e.getStackTrace();
            for (StackTraceElement stackTraceElement:stackTraceElements
                 ) {
                String className=e.getClass().getName();
                int line=stackTraceElement.getLineNumber();
                if (ourName.equals(className)) {
                    System.out.println("line: ");
                    System.out.println();
                    break;
                }
            }
        }


//        if (Math.random()>0.5)
//            new HashMap<String, String>(null);
//        else
//            Integer.parseInt("привет");
    }
}
