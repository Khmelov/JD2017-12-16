package by.it.sendetskaya.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Class<?>structBean=Bean.class;

        Class<? extends Annotation> annotation=Param.class;
        structBean.getDeclaredAnnotations();

        Method[] methods=structBean.getDeclaredMethods();
        Method a=annotation.getMethod("a");
        Method b=annotation.getMethod("b");

        Object instance = structBean.getDeclaredConstructor().newInstance();

        for (Method method:methods) {
           // Annotation annotation1 = method.getDeclaredAnnotation(annotation);

            if(method.isAnnotationPresent(annotation))
            {
                Annotation annotation1=method.getAnnotation(annotation);
                int aInvoke= (int) a.invoke(annotation1);
                int bInvoke= (int) b.invoke(annotation1);
                String strMethod=method.getName();
                double result;

                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    result = (double) method.invoke(null, aInvoke,bInvoke);
                } else {
                    result = (double) method.invoke(instance, aInvoke,bInvoke);
                }

                System.out.print("Метод класса Bean с аннотациями: "+strMethod);
                System.out.println(", результат метода: "+result);
            }
            }
        }

}
