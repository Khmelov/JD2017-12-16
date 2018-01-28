package by.it.karpeichyk.jd01_13;


import java.util.HashMap;

/**
 * Created by user on 18.01.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        try{
        if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
        }
        catch (NullPointerException |NumberFormatException e){
           String name= e.getClass().getName();
            System.out.println("NullPointerException");
            System.out.println("name:"+name);
           String ourName= TaskA.class.getName();
           StackTraceElement[]stackTraceElements=e.getStackTrace();
           for (StackTraceElement el:stackTraceElements){
               String className= el.getClassName();
               int lineNumber=el.getLineNumber();
               if(ourName.equals(className)) {
                   System.out.println("class;" + className);
                   System.out.println("line:" + lineNumber);
                   System.out.println();
                   break;
               }
           }
        }

    }
}
