package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.Actions;
import by.it.vshelukhin.jd03_07.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        request.getSession().invalidate();
        request.setAttribute(Msg.MESSAGE, "Вы вышли");
        return Actions.LOGOUT.actionCommand;
    }
}
