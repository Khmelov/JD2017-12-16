package by.it.krasutski.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) {
        Class<?> structBean = Bean.class;
        Method[] methods = structBean.getDeclaredMethods();
        Object obj;
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Param.class)) {
                    obj = structBean.getConstructor().newInstance();
                    Param annotation = method.getAnnotation(Param.class);
                    System.out.println("Метод " + method.getName() + " : "
                            + method.invoke(obj, annotation.a(), annotation.b()));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
