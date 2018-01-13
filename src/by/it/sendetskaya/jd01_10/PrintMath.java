package by.it.sendetskaya.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    //Sample reflection API
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?>structMath=Math.class;
        structMath.getDeclaredAnnotations();
        Class<?>structString=String.class;
        Method[] methods=structMath.getDeclaredMethods();
        Field[]fields=structMath.getDeclaredFields();
        Method[] methodsString=structString.getDeclaredMethods();

        //find all methods Math class
        for (Method method:methods) {
            if ((method.getModifiers()& Modifier.PUBLIC)==Modifier.PUBLIC) {
                String strMethod = (method).toString();
                strMethod=strMethod.replace("java.lang.Math.","");
                strMethod=strMethod.trim();
                System.out.println(strMethod);
            }
        }
        for (Field field:fields) {
            if ((field.getModifiers()& Modifier.PUBLIC)==Modifier.PUBLIC) {
                String strField = (field).toString();
                strField=strField.replace("java.lang.Math.","");
                strField=strField.trim();
                System.out.println(strField);
            }
        }

//        for (Method method:methodsString) {
//            //find static
////            if ((method.getModifiers()& Modifier.STATIC)==Modifier.STATIC)
////            System.out.println(method);
//
//            //find method with int
//            Class<?>[]params=method.getParameterTypes();
//            if(params.length==1&&params[0]==int.class) {
//                System.out.println(method);
//                //find by name
//                if(method.getName().equals("valueOf"))
//                {
//                    //call method
//                   String result=(String) method.invoke(null,123);
//                    System.out.println(result);
//                }
//            }
 //       }
    }
}
