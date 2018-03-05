package by.it.krasutski.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    Action defineCommand(HttpServletRequest req) {
        Action command;
        String action = req.getParameter("command");
        if (action == null)
            action = "CommandHome";
        try {
            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command = currentEnum.command;
        } catch (IllegalArgumentException e) {
            command = Actions.ERROR.command;
        }
        return command;

    }
}
