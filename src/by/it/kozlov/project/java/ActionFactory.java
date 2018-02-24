package by.it.kozlov.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command;
        String action = request.getParameter("command");
        try {
            Actions actEnum = Actions.valueOf(action.toUpperCase());
            command = actEnum.getCommand();
        } catch (IllegalArgumentException e) {
            command = Actions.ERROR.command;
        }
        return command;
    }
}
