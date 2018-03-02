package by.it.krasutski.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    ActionCommand defineCommand(HttpServletRequest req) {
        ActionCommand command;
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
