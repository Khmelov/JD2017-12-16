package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandLogOut extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req) throws ParseException, SQLException {
        req.getSession().invalidate();

//        req.setAttribute(Msg.PROFILE_LOGIN,LogInBuyer.currentBuyer!=null?LogInBuyer.currentBuyer.getLogin():"");
        req.setAttribute(Msg.BUYER, "");

        return Actions.LOGIN.command;
    }
}
