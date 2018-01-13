package by.it.vshelukhin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> stractMath = Math.class;

        Field[] f = stractMath.getDeclaredFields();

        for (Field field : f) {
            if (field.toString().matches("public.+")) {
                System.out.println(field.toString().replace("java.lang.Math.", ""));
            }
        }
        System.out.println();

        Method[] m = stractMath.getDeclaredMethods();
        for (Method method : m) {
            if (method.toString().matches("public.+")) {
                System.out.println(method.toString().replace("java.lang.Math.", ""));
            }
        }
    }
}
