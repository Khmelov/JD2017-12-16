package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.dao.beans.User;
import by.it.krasutski.project.java.dao.beansDAO.DAO;

import javax.servlet.http.HttpServletRequest;

public class  CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        if (FormUtil.isPost(req))
            return Actions.SIGNUP.jsp;
        String login =
                FormUtil.getString(req.getParameter("Login"), Patterns.LOGIN);
        String email =
                FormUtil.getString(req.getParameter("Email"), Patterns.EMAIL);
        String password =
                FormUtil.getString(req.getParameter("Password"), Patterns.PASSWORD);
        String nickname =
                FormUtil.getString(req.getParameter("Nickname"), Patterns.NICKNAME);
        String phonenumber =
                FormUtil.getString(req.getParameter("PhoneNumber"), ".+");

        User user = new User(0, login, email, password, nickname, phonenumber, 2);
        DAO dao = DAO.getDAO();
        dao.userDAO.create(user);
        if (user.getID() > 0)
            return Actions.LOGIN.jsp;
        else {
            req.setAttribute(Msg.ERROR, "Fail to create.");
            req.setAttribute(Msg.MESSAGE, "User already exist.");
            return Actions.SIGNUP.jsp;
        }
    }
}
