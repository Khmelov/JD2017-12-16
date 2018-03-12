package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.ResetDB_akhmelev;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CommandResetDB extends Command {
    @Override
    public Command execute(HttpServletRequest req) throws SQLException, ClassNotFoundException {
        if (Util.isPost(req)) {
            req.setAttribute(Msg.MESSAGE,"POST. Команда сброса базы. Возможно вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
            ResetDB_akhmelev.main(null);
            req.setAttribute(Msg.MESSAGE,"POST. Сброс базы завершился успешно.");
            req.getSession().invalidate();
        }
        return null;
    }
}