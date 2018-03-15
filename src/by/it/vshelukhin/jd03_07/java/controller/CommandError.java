package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.Actions;

import javax.servlet.http.HttpServletRequest;

public class CommandError extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        return Actions.ERROR.actionCommand;
    }
}
