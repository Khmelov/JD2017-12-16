package by.it.karpeichyk.Project.java;


import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by user on 22.02.2018.
 */
public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws  Exception {
        if (!FormUtil.isPost(req))
        return Action.LOGIN.jsp;
        String login = FormUtil.getString(req.getParameter("Login"),".+");
        String pasword = FormUtil.getString(req.getParameter("Pasword"),".+");
        MyDAO dao = MyDAO.getMyDAO();
        List<User> list = dao.myUserDAO.getAll("where Login='" + login + "' and Pasword='" + pasword + "'");
        if (list.size()>0)
            req.setAttribute(Msg.MESSAGE,"пользователь " +login+" найден");
        else
            req.setAttribute(Msg.ERROR,"пользователь " + login + " не найден");
        return Action.LOGIN.jsp;
    }
}
