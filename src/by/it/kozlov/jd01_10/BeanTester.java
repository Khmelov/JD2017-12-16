package by.it.kozlov.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> structBean = Bean.class;
        Object bObj = structBean.newInstance();
        Method[] methods = structBean.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                System.out.println(method.getName() + method.invoke(bObj, param.a(), param.b()));
            }
        }
    }
}
