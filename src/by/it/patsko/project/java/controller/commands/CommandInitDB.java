package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandInitDB extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req) throws ParseException, SQLException {
        if (!FormUtil.isPost(req)) {
            C_Init.main(null);
            req.setAttribute(Msg.MESSAGE,"База данных восстановлена!!!");
        }
        return Actions.INITDB.command;

    }
}
