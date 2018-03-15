package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.Actions;
import by.it.vshelukhin.jd03_07.java.controller.FormUtil;
import by.it.vshelukhin.jd03_07.java.controller.Msg;
import by.it.vshelukhin.jd03_07.java.dao.MyReset;

import javax.servlet.http.HttpServletRequest;

public class CommandResetDB extends Action {

    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if (FormUtil.isPost(request)) {
            request.setAttribute(Msg.MESSAGE,"POST1. Сброс базы. Если завершается здесь, то возможно вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
            new MyReset().run();
            request.setAttribute(Msg.MESSAGE,"POST2. Сброс базы завершился успешно.");
        }
        return Actions.RESETDB.actionCommand;
    }
}
