package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.LOGIN.jsp;
    }
}
