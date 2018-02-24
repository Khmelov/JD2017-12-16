package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.ActionCommand;
import by.it.akhmelev.project5.java.Actions;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command;
        String action = request.getParameter("command");
        try {
            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            command = Actions.ERROR.command;
        }
        return command;
    }
}
