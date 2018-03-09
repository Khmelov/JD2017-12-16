package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.controller.Action;
import by.it.akhmelev.project8.java.controller.Actions;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    Action defineCommand(HttpServletRequest request) {
        Action command;
        String action = request.getParameter("command");
        if (action==null)
            action="Index";
        try {
            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command = currentEnum.command;
        } catch (IllegalArgumentException e) {
            command = Actions.ERROR.command;
        }
        return command;
    }
}
