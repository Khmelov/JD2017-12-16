package by.it.korobeinikov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintMath {

    public static void main(String[] args) {
        Class<?> structMath = Math.class;
        Method[] methods = structMath.getMethods();
        for (Method method : methods) {
            System.out.println(deleteNameJava(method.toString()));
        }
        Field[] fields = structMath.getFields();
        for (Field field : fields) {
            System.out.println(deleteNameJava(field.toString()));
        }
    }

    public static String deleteNameJava(String string) {
        StringBuilder sb = new StringBuilder(string);
        Pattern pattern = Pattern.compile("java.");
        Matcher matcher = pattern.matcher(sb);
        if (matcher.find()) {
            sb = sb.delete(matcher.start(), matcher.start() + 15);
        }
        return sb.toString();
    }
}
