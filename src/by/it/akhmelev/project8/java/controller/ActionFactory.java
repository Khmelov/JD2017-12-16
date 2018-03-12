package by.it.akhmelev.project8.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    Command defineCommand(HttpServletRequest request) {
        Command command;
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
