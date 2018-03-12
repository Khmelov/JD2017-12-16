package by.it.vshelukhin.jd03_06.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {
    static String getString(String value, String regxp) throws ParseException {
        if (value.matches(regxp))
            return value;
        else
            throw new ParseException("Input error",1);
    }
    static int getInt(HttpServletRequest req, String field) throws ParseException {
        String value=req.getParameter(field);
        return Integer.parseInt(value);
    }
    static double getDouble(HttpServletRequest req, String field) throws ParseException {
        String value=req.getParameter(field);
        return Double.parseDouble(value);
    }

    static boolean isPost(HttpServletRequest reg){
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
