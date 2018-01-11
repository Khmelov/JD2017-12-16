package by.it.patsko.jd01_10;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    static String printParametrTypes(Class<?>[] param){
        String s=new String();
        for (Class<?> p : param) {
            s+=p.toString();
            if(p!=param[0]||p!=param[param.length-1]){s+=", ";}
        }
        return s;
    }
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                if (method.getModifiers() == (Modifier.PUBLIC + Modifier.STATIC)) System.out.print("public static ");

            System.out.println(method.getReturnType() + " " + method.getName() + "(" +printParametrTypes(method.getParameterTypes()) + ")");

//            System.out.println(method);
        }

        /*Class<?> structString = String.class;
//        structString.getDeclaredAnnotations();
        Method[] methods = structString.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println(method);
            //find static
            *//*if((method.getModifiers()&Modifier.STATIC)==Modifier.STATIC)
                System.out.println(method);*//*
            //find method
            Class<?>[] params = method.getParameterTypes();
            if (params.length == 1 && params[0] == int.class) {
                System.out.println(method);
                //find name
                if (method.getName().equals("valueOf")) {
                    String res = (String) method.invoke(null, 123);//вызов метода
                    System.out.println(res);
                }
            }

        }*/
    }
}
