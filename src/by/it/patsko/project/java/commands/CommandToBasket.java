package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.ActionCommand;
import by.it.patsko.project.java.Actions;
import by.it.patsko.project.java.Msg;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class CommandToBasket implements ActionCommand  {
    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(Msg.MESSAGE, "Пока не реализовано");
//        req.setAttribute(Msg.MESSAGE, Arrays.toString(req.getCookies()));
        return Actions.CATEGORYCS.jsp;
    }
}
