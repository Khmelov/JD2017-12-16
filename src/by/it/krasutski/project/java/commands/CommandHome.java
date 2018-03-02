package by.it.krasutski.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class CommandHome implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) {
        return Actions.HOME.jsp;
    }
}
