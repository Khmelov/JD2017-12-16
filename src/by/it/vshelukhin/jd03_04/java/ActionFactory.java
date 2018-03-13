package by.it.vshelukhin.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    ActionCommand actionCommand;
    ActionCommand getActionCommand(HttpServletRequest req){
        String comand = req.getParameter("command").toUpperCase();
        actionCommand = Action.valueOf(comand).getAction();
        return actionCommand;
    }
}
