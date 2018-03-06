package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.helpers.ResetDB;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CommandResetDB extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, ClassNotFoundException {
        if (FormUtil.isPost(req)){
            req.setAttribute(Msg.MESSAGE, "Сброс базы не выполнен. Взможно вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
            ResetDB.main(null);
            req.setAttribute(Msg.MESSAGE, "Сброс (создание) базы выполнен успешно");
        }
        return null;
    }
}
