package by.it.pozdeev.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> structBean = Bean.class;
        Object object = structBean.newInstance();
        Method[] methods = structBean.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                System.out.println(method);
                Param prmMet = method.getAnnotation(Param.class);
                System.out.println(method.invoke(object,prmMet.a(),prmMet.b()));
            }
        }
    }
}

