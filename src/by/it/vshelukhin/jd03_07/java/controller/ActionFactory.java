package by.it.vshelukhin.jd03_07.java.controller;



import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.Actions;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    Action getActionCommand(HttpServletRequest req){
        Action actionCommand;
        try {
        String comand = req.getParameter("command").toUpperCase();
        actionCommand = Actions.valueOf(comand).getAction();
        } catch (IllegalArgumentException e) {
            actionCommand = Actions.ERROR.actionCommand;
        }
        return actionCommand;


    }
}
