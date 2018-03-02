package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandInitDB implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws ParseException, SQLException {
        if (!FormUtil.isPost(req)) {
            C_Init.main(null);
            req.setAttribute(Msg.MESSAGE,"База данных восстановлена!!!");
        }
        return Actions.INITDB.jsp;

    }
}
