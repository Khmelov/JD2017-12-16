package by.it._tasks_.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintString {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mathClass=String.class;
        Method[] m=mathClass.getDeclaredMethods();
        for (Method method : m) {
            if (!method.toString().contains("static"))
                System.out.println(".include(\""+method.getName()+"\")");
//            else
//                System.out.println(".exclude(\""+method.getName()+"\")");
        }


    }
}
