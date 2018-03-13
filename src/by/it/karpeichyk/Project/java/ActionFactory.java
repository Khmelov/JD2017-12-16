package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 22.02.2018.
 */
public class ActionFactory {
    AbstractAction defineCommand(HttpServletRequest request){
        AbstractAction command;
        String action = request.getParameter("command");
        if (action==null)
            action="Index";

        try {
            Action currentEnum = Action.valueOf(action.toUpperCase());
            command = currentEnum.command;
        }catch (IllegalArgumentException e){
            command = Action.ERROR.command;
        }
           return command;
    }
}
