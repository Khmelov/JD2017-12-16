package by.it.vshelukhin.jd03_06.java.controller;


import by.it.vshelukhin.jd03_06.java.dao.DAO;
import by.it.vshelukhin.jd03_06.java.entity.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if (!FormUtil.isPost(request))
            return Actions.LOGIN.actionCommand;
        String login =
                FormUtil.getString(request.getParameter("Login"), ".+");
        String password =
                FormUtil.getString(request.getParameter("Password"), ".+");
        DAO dao = DAO.getDAO();
        List<Student> list = dao.studentDAO.readAll(" where login='" + login + "' and password='" + password + "'");
        if (list.size() > 0) {
            //request.setAttribute(Msg.MESSAGE, "пользователь " + login + " найден");
            HttpSession session = request.getSession();
            session.setAttribute("student", list.get(0));
            session.setAttribute("CurrentNameStud", list.get(0).getLogin());
            return Actions.ALLORDERS.actionCommand;
        }
        else
            request.setAttribute(Msg.ERROR, "пользователь " + login + " НЕ найден");

        return Actions.LOGIN.actionCommand;
    }
}
