package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.ERROR.jsp;
    }
}
