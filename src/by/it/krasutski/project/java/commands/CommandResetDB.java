package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.database.DataBaseInit;
import by.it.krasutski.project.java.database.DataBaseReset;

import javax.servlet.http.HttpServletRequest;

public class CommandResetDB extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req)) {
            DataBaseReset.resetDB();
            DataBaseInit.initDB();
            req.setAttribute(Msg.MESSAGE,"Database reset and created.");
            req.getSession().invalidate();
        }
        return null;
    }
}