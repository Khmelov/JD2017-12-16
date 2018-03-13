package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by user on 02.03.2018.
 */
public class FormUtil {
    static String getString(HttpServletRequest req, String field, String regxp) throws ParseException{
        String value=req.getParameter(field);
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