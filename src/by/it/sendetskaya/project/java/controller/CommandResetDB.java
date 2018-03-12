package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.CreateNewSchema;
import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CommandResetDB extends Action {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (FormUtil.isPost(req)) {
            req.setAttribute(Msg.MESSAGE,"POST1. Сброс базы. Если завершается здесь, то возможно вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
            CreateNewSchema.main(null);
            req.setAttribute(Msg.MESSAGE,"POST2. Сброс базы завершился успешно.");
            req.getSession().invalidate();
        }
        return null;
    }
}