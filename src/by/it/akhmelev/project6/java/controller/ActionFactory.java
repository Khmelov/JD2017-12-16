package by.it.akhmelev.project6.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
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
