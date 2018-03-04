package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 22.02.2018.
 */
public class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Action.ERROR.jsp;
    }
}
