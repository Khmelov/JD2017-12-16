package by.it.patsko.project.java;

import javax.servlet.http.HttpServletRequest;

class CommandError implements ActionCommand{
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.ERROR.jsp;
    }
}
