package by.it.sevashko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {

    static boolean isPost(HttpServletRequest request){
        return request.getMethod().toUpperCase().equals("POST");
    }

    static String checkValue(String value, String regex) throws ParseException {
        if (value.matches(regex)) return  value;
        else throw new ParseException("Input ERROR", 1);
    }

    static int getInt(HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        return Integer.parseInt(value);
    }

    static double getDouble(HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        return Double.parseDouble(value);
    }
}
