package by.it.patsko.project.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {
    /*public static String getString(HttpServletRequest request, String parametr, String pattern) throws ParseException {
        String value=request.getParameter(parametr);
        if((value!=null)&&value.matches(pattern)) return value;
        else{
            throw new ParseException("Input error: "+parametr+"\nrequest.getParameter(parametr)="+request.getParameter(parametr)+"\n\n", 1);}
    }*/
    public static String getString(String value, String regxp) throws ParseException {
        if (value.matches(regxp)) return value;
        else throw new ParseException("Input error", 1);
    }

    public static boolean isPost(HttpServletRequest reg) {
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
