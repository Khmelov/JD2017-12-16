package by.it.karpeichyk.Project.java;


import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 22.02.2018.
 */
 class CommandLogin extends  AbstractAction{
    @Override
    public AbstractAction execute(HttpServletRequest req) throws  Exception {
        if (!FormUtil.isPost(req))
        return Action.LOGIN.command;
        String login = FormUtil.getString(req,"Login",".+");
        String pasword = FormUtil.getString(req,"pasword",".+");
        MyDAO dao = MyDAO.getMyDAO();
        List<User> list = dao.myUserDAO.getAll("where login='" + login + "' and Pasword='" + pasword + "'");
        if (list.size()>0) {
            req.setAttribute(Msg.MESSAGE, "пользователь " + login + " найден");
            HttpSession session = req.getSession();
            session.setAttribute("user", list.get(0));
            return null;
        }  else {
            req.setAttribute(Msg.ERROR, "пользователь " + login + " не найден");
            return Action.LOGIN.command;
        }
    }
}
