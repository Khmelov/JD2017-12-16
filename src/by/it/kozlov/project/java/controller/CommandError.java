package by.it.kozlov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandError extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        return Actions.ERROR.command;
    }
}
