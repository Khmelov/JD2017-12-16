package by.it.vshelukhin.jd03_05.java;



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
