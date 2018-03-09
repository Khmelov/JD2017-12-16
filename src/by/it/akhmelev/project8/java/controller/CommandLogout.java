package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.controller.Action;
import by.it.akhmelev.project8.java.controller.Actions;

import javax.servlet.http.HttpServletRequest;

class CommandLogout extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return Actions.LOGIN.command;
    }
}
