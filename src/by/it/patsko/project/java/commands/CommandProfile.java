package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CommandProfile implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) throws SQLException {
        req.setAttribute(Msg.PROFILE_LOGIN, LogInBuyer.currentBuyer.getLogin());
        req.setAttribute(Msg.PROFILE_PASSWORD, LogInBuyer.currentBuyer.getPassword());

        return Actions.PROFILE.jsp;
    }
}
