package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandResetDB implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws ParseException, SQLException {
        if (!FormUtil.isPost(req)) {
            C_Reset.main(null);
            req.setAttribute(Msg.MESSAGE, "База данных удалена!!!");
        }
        return Actions.RESETDB.jsp;
    }
}
