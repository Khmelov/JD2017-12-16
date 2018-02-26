package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CommandLogIn implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        if (!FormUtil.isPost(req)) return Actions.LOGIN.jsp;
        try {
            String test= FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
//            String test= FormUtil.getString(req,"Login", Pattern.LOGIN);
            req.setAttribute(Msg.MESSAGE,"test="+test);
        } catch (ParseException e) {
            req.setAttribute(Msg.ERROR,e.getMessage()+"\n");
        }
        return Actions.LOGIN.jsp;
//        return null;
    }
}
