package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.ActionCommand;
import by.it.akhmelev.project5.java.Actions;
import by.it.akhmelev.project5.java.dao.DAO;
import by.it.akhmelev.project5.java.dao.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws Exception{
        if (!FormUtil.isPost(req))
            return Actions.SIGNUP.jsp;
        String login =
                FormUtil.getString(req.getParameter("Login"), ".+");
        String password =
                FormUtil.getString(req.getParameter("Password"), ".+");
        DAO dao=DAO.getDAO();
        List<User> list=dao.userDAO.getAll(" where Login="+login+" and Password="+password);
        if (list.size()>0)
            req.setAttribute(Msg.MESSAGE,"пользователь найден");
        return Actions.LOGIN.jsp;

    }
}
