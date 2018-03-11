package by.it._tasks_.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> clazz=Bean.class;
        Object instance=clazz.getDeclaredConstructor().newInstance();
        Method[] methods=clazz.getDeclaredMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Param.class)){
                Param p=(Param)method.getAnnotation(Param.class);
                int a=p.a();
                int b=p.b();
                System.out.println(method.getName()+": "+method.invoke(instance,a,b));
            }
        }
    }
}
