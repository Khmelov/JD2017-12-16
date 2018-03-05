package by.it.krasutski.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout extends Action {

    @Override
    public Action execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return Actions.LOGIN.command;
    }
}
