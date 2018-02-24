package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.dao.DAO;
import by.it.akhmelev.project5.java.dao.bean.User;

import javax.servlet.http.HttpServletRequest;

public class CommandSignup implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return Actions.SIGNUP.jsp;
        req.setAttribute(Msg.MESSAGE,"POST1");
        String login =
                FormUtil.getString(req.getParameter("Login"), ".+");
        String email =
                FormUtil.getString(req.getParameter("Email"), ".+");
        String password =
                FormUtil.getString(req.getParameter("Password"), ".+");
        req.setAttribute(Msg.MESSAGE,"POST2");
        User user=new User(0,login,email,password,1);
        req.setAttribute(Msg.MESSAGE,"POST3");
        DAO dao=DAO.getDAO();
        req.setAttribute(Msg.MESSAGE,"POST4");
        dao.userDAO.create(user);
        req.setAttribute(Msg.MESSAGE,"POST5");
        if (user.getId()>0)
            return Actions.LOGIN.jsp;
        else
        {
            req.setAttribute(Msg.MESSAGE,"Ошибка добавления пользователя");
            return Actions.SIGNUP.jsp;
        }
    }
}
