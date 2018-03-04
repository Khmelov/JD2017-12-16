package by.it.patsko.project.java;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {

    public static String getString(String value, String regxp) {
        if(value==null) return null;
        else if (value.matches(regxp)) return value;
        else return null;
    }

    public static boolean isPost(HttpServletRequest reg) {
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
