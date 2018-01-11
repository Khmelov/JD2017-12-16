package by.it.kozlov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> bean=Bean.class;

        Method[] methods=bean.getDeclaredMethods();
        for (Method method:methods){
            Annotation[] annotations=method.getAnnotations();
            for (Annotation annotation:annotations)
            System.out.println(annotation);
        }
    }
}
