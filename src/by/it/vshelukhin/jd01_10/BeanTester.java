package by.it.vshelukhin.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Annotation;

public class BeanTester {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> structBean = Bean.class;
        Object o = structBean.newInstance();
        Method[] m = structBean.getMethods();
        for (Method method : m) {
            if (method.isAnnotationPresent(Param.class)) {
                System.out.println(method);
                Param prmMet = method.getAnnotation(Param.class);
                System.out.println(method.invoke(o,prmMet.a(),prmMet.b()));
            }
        }
    }
}
