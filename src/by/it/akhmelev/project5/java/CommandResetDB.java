package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.dao.ResetDB_akhmelev;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CommandResetDB implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws SQLException, ClassNotFoundException {
        if (FormUtil.isPost(req)) {
            req.setAttribute(Msg.MESSAGE,"POST1. Сброс базы. Если завершается здесь, то возможно вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
            ResetDB_akhmelev.main(null);
            req.setAttribute(Msg.MESSAGE,"POST2. Сброс базы завершился успешно.");
        }
        return Actions.RESETDB.jsp;
    }
}