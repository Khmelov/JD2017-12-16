package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 22.02.2018.
 */
public class CommandLogOut extends AbstractAction {
    @Override
    public AbstractAction execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return Action.LOGOUT.command;
    }
}
