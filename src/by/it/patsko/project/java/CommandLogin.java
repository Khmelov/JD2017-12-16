package by.it.patsko.project.java;

import javax.servlet.http.HttpServletRequest;

class CommandLogIn implements ActionCommand{
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.LOGIN.jsp;
    }
}
