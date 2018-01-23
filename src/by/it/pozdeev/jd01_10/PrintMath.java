package by.it.pozdeev.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> m = Math.class;
        Field[] fields = m.getDeclaredFields();
        for (Field field : fields) {
            if (field.toString().matches("public.+")) {
                System.out.println(field.toString().replace("java.lang.Math.", ""));
            }
        }
        System.out.println();

        Method[] mmath = m.getDeclaredMethods();
        for (Method method : mmath) {
            if (method.toString().matches("public.+")) {
                System.out.println(method.toString().replace("java.lang.Math.", ""));
            }
        }
    }
}
