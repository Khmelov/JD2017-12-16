package by.it.kozlov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

abstract class Action {
    abstract Action execute(HttpServletRequest request) throws ParseException, SQLException;

    String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replaceFirst("Command", "");
    }
}
