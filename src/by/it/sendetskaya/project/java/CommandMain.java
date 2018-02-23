package by.it.sendetskaya.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandMain implements ActionCommand{
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.MAIN.jsp;
    }
}