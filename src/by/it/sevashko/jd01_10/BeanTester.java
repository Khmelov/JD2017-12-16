package by.it.sevashko.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) {
        Class<?> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
//        Method[] methods = beanClass.getMethods();
        try{
            Object o = null;
            for (Method method : methods){
                if (method.isAnnotationPresent(Param.class)){
                    Param annotInstance = method.getAnnotation(Param.class);
                    if ((Modifier.isStatic(method.getModifiers()))){
                        double result = (double) method.invoke(null, annotInstance.a(), annotInstance.b());
                        System.out.println(method.getName());
                        System.out.println(result);
                    }
                    else {
                        if (o == null){
                            Constructor<?> beanConstructor = beanClass.getConstructor();
                            o = beanConstructor.newInstance();
                        }
                        double result = (double) method.invoke(o, annotInstance.a(), annotInstance.b());
                        System.out.println(method.getName());
                        System.out.println(result);
                    }
                }
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
