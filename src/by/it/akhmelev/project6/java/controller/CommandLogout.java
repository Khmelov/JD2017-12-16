package by.it.akhmelev.project6.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return Actions.LOGIN.command;
    }
}
