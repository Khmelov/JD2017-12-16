package by.it._tasks_.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class mathClass=Math.class;
        Method[] m=mathClass.getDeclaredMethods();
        for (Method method : m) {
            String str=".include(\""+method.toString()+"\")";
            str=str.replace("java.lang.Math.","");
            if (!str.contains("public static"))
                str=str.replace(".include",".exclude");
            else
            System.out.println(str);
        }

        Field[] fields=mathClass.getDeclaredFields();
        for (Field field : fields) {
            String str=".include(\""+field.toString()+"\")";
            str=str.replace("java.lang.Math.","");
            if (!str.contains("public static"))
                str=str.replace(".include",".exclude");
            else
            System.out.println(str.replaceAll("java.lang.Math.",""));
        }

    }
}
