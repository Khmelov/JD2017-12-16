package by.it.sevashko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    Action defineCommand(HttpServletRequest req){
        Action command;
        String action = req.getParameter("command");
        try {
            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            command = Actions.ERROR.command;
        }
        return command;
    }
}
