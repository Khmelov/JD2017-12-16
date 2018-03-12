package by.it.akhmelev.project8.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class Util {

    static String frmString(HttpServletRequest req, String field, String regxp) throws ParseException {
        String value=req.getParameter(field);
        if (value.matches(regxp))
            return value;
        else
            throw new ParseException("Input error",1);
    }
    static int frmInt(HttpServletRequest req, String field) throws ParseException {
        String value=req.getParameter(field);
        return Integer.parseInt(value);
    }
    static double frmDouble(HttpServletRequest req, String field) throws ParseException {
        String value=req.getParameter(field);
        return Double.parseDouble(value);
    }

    static boolean isPost(HttpServletRequest reg){
        return reg.getMethod().toUpperCase().equals("POST");
    }

    @SuppressWarnings({"unchecked", "WeakerAccess"})
    static<Type> Type findInSession(HttpServletRequest req, String name){
        Type result=null;
        Object object = req.getSession().getAttribute(name);
        if (object!=null){
            result=(Type)object;
        }
        return result;
    }
}
