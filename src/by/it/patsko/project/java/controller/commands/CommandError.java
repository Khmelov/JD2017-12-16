package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;

public class CommandError extends ActionCommand {
    static String errorMassage;
    static String errorDetails;

    @Override
    public ActionCommand execute(HttpServletRequest req) {
        req.setAttribute(Msg.ERROR, errorMassage);
        req.setAttribute(Msg.ERROR_DETAILS, errorDetails);
        return Actions.ERROR.command;
    }
}
