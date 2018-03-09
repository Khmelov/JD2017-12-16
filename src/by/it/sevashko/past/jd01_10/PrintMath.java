package by.it.sevashko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        printPublicMethods(Math.class);
        printPublicFields(Math.class);
    }

    private static  void printPublicMethods(Class<?> structure){
        Method[] methods = structure.getMethods();
        for (Method method : methods){
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                StringBuilder line = new StringBuilder();
                line.append(Modifier.toString(method.getModifiers()));
                line.append(" ");
                line.append(method.getReturnType().getSimpleName());
                line.append(" ");
                line.append(method.getName());
                line.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i > 0) line.append(',');
                    line.append(parameterTypes[i].getSimpleName());
                }
                line.append(")");
                System.out.println(line);
            }
        }
    }

    private static void printPublicFields(Class<?> structure){
        Field[] fields = structure.getFields();
        for (Field field : fields){
            if (Modifier.isPublic(field.getModifiers())){
                System.out.print(field.getType() + " ");
                System.out.print(field.getName());
                System.out.println();
            }
        }
    }

}
