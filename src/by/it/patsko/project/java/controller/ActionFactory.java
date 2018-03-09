package by.it.patsko.project.java.controller;

import by.it.patsko.project.java.controller.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest req){
        ActionCommand command;
        String action=req.getParameter("command");
        if (action==null)
            action="Index";
        try {
            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command=currentEnum.command;
        }catch (IllegalArgumentException e){
            command=Actions.ERROR.command;
        }
        return command;
    }
}
