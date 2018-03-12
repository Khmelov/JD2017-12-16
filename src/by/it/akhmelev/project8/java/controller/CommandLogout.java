package by.it.akhmelev.project8.java.controller;

import javax.servlet.http.HttpServletRequest;

class CommandLogout extends Command {
    @Override
    public Command execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return Actions.LOGIN.command;
    }
}
