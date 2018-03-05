package by.it.kozlov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandError extends Action {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        return Actions.ERROR.command;
    }
}
