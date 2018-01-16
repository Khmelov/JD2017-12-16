package by.it.vshelukhin.jd01_10;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintString {
    public static void main(String[] args) {
        Class<?> structString = String.class;
        Method[] m = structString.getDeclaredMethods();
        Pattern pat = Pattern.compile("String\\..+?\\(");
        for (Method method : m) {
            if (!method.toString().matches(".*static.*")) {
                Matcher mat = pat.matcher(method.toString());
                if (mat.find()) System.out.println(mat.group().replace("String.","").replace("(",""));
            }
        }
    }
}
