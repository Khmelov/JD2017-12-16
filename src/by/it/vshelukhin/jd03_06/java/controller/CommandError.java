package by.it.vshelukhin.jd03_06.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandError extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        return Actions.ERROR.actionCommand;
    }
}
