package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.ActionCommand;
import by.it.patsko.project.java.Actions;
import by.it.patsko.project.java.LogInBuyer;
import by.it.patsko.project.java.Msg;

import javax.servlet.http.HttpServletRequest;

public class CommandLogOut implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        LogInBuyer.resetInstance();

        req.setAttribute(Msg.PROFILE_LOGIN,LogInBuyer.currentBuyer!=null?LogInBuyer.currentBuyer.getLogin():"");
//        req.setAttribute(Msg.BUYER,LogInBuyer.currentBuyer!=null?LogInBuyer.currentBuyer.getLogin():"");

        return Actions.LOGOUT.jsp;
    }
}
