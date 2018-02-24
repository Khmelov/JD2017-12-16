package by.it.akhmelev.project5.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {
    static String getString(String value, String regxp) throws ParseException {
        if (value.matches(regxp))
            return value;
        else
            throw new ParseException("Input error",1);
    }

    static boolean isPost(HttpServletRequest reg){
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
