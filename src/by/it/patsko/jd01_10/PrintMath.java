package by.it.patsko.jd01_10;


import java.lang.reflect.*;

/*
TaskB1. Напишите программу PrintMath, которая выводит на консоль все публичные поля
и методы стандартного класса Math в следующем формате (тест потребует точное совпадение!):
public static float abs(float)
public static double pow(double,double)и т.д.
(если будут несовпадения тест укажет, что он ожидал)
 */
public class PrintMath {
    private static String printParametrTypes(Class<?>[] param) {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i < param.length; i++) {


            s.append(param[i].toString());
            if (i != param.length - 1) s.append(",");
        }
        s.append(")");
        return s.toString();
    }

    public static void main(String[] args) {
        Class<?> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() +
                        " " + method.getName() + printParametrTypes(method.getParameterTypes()));
//            System.out.println(method.toString().replace("java.lang.Math.",""));
        }
        System.out.println();
        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
//            System.out.println(field.toString().replace("java.lang.Math.", ""));
        }
    }
}
