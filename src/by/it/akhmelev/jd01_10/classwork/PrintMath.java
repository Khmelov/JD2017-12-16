package by.it.akhmelev.jd01_10.classwork;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    //Sample reflection API
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> stuctMath = String.class;
        Method[] methods = stuctMath.getDeclaredMethods();
        for (Method method : methods) {
            //find static
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                System.out.println(method);
            //find methos with (int)
            Class<?>[] params = method.getParameterTypes();
            if (params.length == 1 && params[0] == int.class)
            {System.out.println(method);
                //find by name
                if (method.getName().equals("valueOf")){
                    //call method
                    String res=(String) method.invoke(null,123);
                    System.out.println(res);
                }
            }

        }
    }
}
