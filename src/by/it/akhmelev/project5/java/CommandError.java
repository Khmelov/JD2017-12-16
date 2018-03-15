package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.ActionCommand;
import by.it.akhmelev.project5.java.Actions;

import javax.servlet.http.HttpServletRequest;

public class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.ERROR.jsp;
    }
}
