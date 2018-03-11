package by.it._tasks_.jd01_13;

import java.util.HashMap;

public class TaskA {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            //e.printStackTrace();
            StackTraceElement[] stack = e.getStackTrace();
            for (StackTraceElement element : stack) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String numline = "  line:" + element.getLineNumber();
                    String clname = " class:" + element.getClassName();
                    System.out.println(e.getClass().getName()+" "+numline + clname);
                    break;
                }
            }
        }
    }
}
