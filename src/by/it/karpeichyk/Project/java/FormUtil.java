package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by user on 02.03.2018.
 */
public class FormUtil {
    static String getString(String value, String regxp) throws ParseException{
        if (value.matches(regxp))
            return  value;
        else
            throw new ParseException("Input Error",1);
    }
    static  boolean isPost (HttpServletRequest reg){return  reg.getMethod().toUpperCase().equals("POST");}

}
