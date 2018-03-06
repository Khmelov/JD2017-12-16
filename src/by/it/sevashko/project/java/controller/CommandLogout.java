package by.it.sevashko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogout extends Action {

    @Override
    public Action execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return Actions.LOGIN.getCommand();
    }
}
