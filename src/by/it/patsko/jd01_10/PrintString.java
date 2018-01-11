package by.it.patsko.jd01_10;
/*
TaskB2.
Напишите программу PrintString, которая выводит на консоль только имена (без модификаторов и сигнатур)
всех нестатических(т.е. экземплярных) методов стандартного класса String.
 */

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintString {
    public static void main(String[] args) {
        Class<?> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                System.out.println(method.getName());
        }
    }
}
//codePoints
//chars