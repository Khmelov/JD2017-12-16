package by.it.patsko.jd01_13;

import java.util.HashMap;

class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("name:" + e.getClass().getName());
//            System.out.println("class:"+TaskA.class.getName());
            String ourName = TaskA.class.getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                String classname = element.getClassName();
                int linenumber = element.getLineNumber();
                System.out.println("class:" + classname);
                System.out.println("line:" + linenumber);
                if (ourName.equals(classname)) {
                    System.out.println("class:" + classname);
                    System.out.println("line:" + linenumber);
                    break;
                }
            }
        }
    }
}
