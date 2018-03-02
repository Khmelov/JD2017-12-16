package by.it.sendetskaya.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    ActionCommand defineCommand(HttpServletRequest request){

        ActionCommand command;
        String action=request.getParameter("command");
        try {


            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command=currentEnum.getCommand();
        }
        catch (IllegalArgumentException e)
        {
            command=Actions.ERROR.command;    //по умолчанию будет стр error
        }


        return command;
    }
}
