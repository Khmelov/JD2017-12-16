package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class CommandToBasket extends ActionCommand  {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) {

        req.setAttribute(Msg.MESSAGE, "Пока не реализовано");
        return Actions.ERROR.command;
    }
}
