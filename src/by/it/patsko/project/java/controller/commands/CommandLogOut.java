package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandLogOut extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        req.getSession().invalidate();
        req.setAttribute(Msg.USER, "");
        return Actions.LOGIN.command;
    }
}
