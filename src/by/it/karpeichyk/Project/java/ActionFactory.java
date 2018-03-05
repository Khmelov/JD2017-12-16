package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 22.02.2018.
 */
public class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest request){
        ActionCommand command;
        String action = request.getParameter("command");

        try {
            Action currentEnum = Action.valueOf(action.toUpperCase());
            command = currentEnum.getCommand();
        }catch (IllegalArgumentException e){
            command = Action.ERROR.command;
        }
           return command;
    }
}
