package by.it.patsko.project.java;

import javax.servlet.http.HttpServletRequest;

class CommandLogOut implements ActionCommand{
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.LOGOUT.jsp;
    }
}
