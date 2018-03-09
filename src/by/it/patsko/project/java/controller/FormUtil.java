package by.it.patsko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {

    public static String getString(String value, String regxp) {
        if(value==null) return null;
        else if (value.matches(regxp)) return value;
        else return null;
    }
    public static String getString(String value) {
        if (value!=null) return value;
        else return null;
    }

    public static Integer getInt(String value) {
        if(value!=null) return Integer.parseInt(value);
        else return null;
    }

    public static boolean isPost(HttpServletRequest reg) {
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
