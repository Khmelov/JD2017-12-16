package by.it.sendetskaya.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    //Sample reflection API
    public static void main(String[] args) {

        Class<?>structString=String.class;
        Method[] methodsString=structString.getDeclaredMethods();

        for (Method method:methodsString) {
            //find not static and print only name
            if ((method.getModifiers()& Modifier.STATIC)!=Modifier.STATIC) {
                String strMethod=method.getName();
                System.out.println(strMethod);
            }
        }
    }
}
