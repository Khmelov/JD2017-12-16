package by.it.sendetskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandLogout extends Action {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        return Actions.LOGIN.command;
    }
}