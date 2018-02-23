package by.it.sevashko.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    ActionCommand defineCommand(HttpServletRequest request){
        ActionCommand command = Actions.ERROR.command;
        String action = request.getParameter("command");
        Actions currentEnum = Actions.valueOf(action.toUpperCase());
        try {
            command = Actions.ERROR.command;
            command = currentEnum.getCommand();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return command;
    }
}
