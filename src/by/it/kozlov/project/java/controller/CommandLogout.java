package by.it.kozlov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        return Actions.LOGOUT.command;
    }
}
