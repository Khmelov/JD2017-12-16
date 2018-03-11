package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

class Util {
    static String getString(HttpServletRequest req, String field, String regxp) throws ParseException {
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

    static<T> T findInSession(HttpServletRequest req, Class<T> classs){
        T t=null;
        Object o = req.getSession().getAttribute(classs.getSimpleName().toLowerCase());
        if (o!=null){
            t=(T)o;
        }
        return t;
    }
}
