package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandSignUP implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws ParseException, SQLException {

        if (!FormUtil.isPost(req))
            return Actions.SIGNUP.jsp;
        String login =FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
        String email = FormUtil.getString(req.getParameter("Email"),Pattern.EMAIL);
        String password =FormUtil.getString(req.getParameter("Password"),Pattern.PASSWORD);
        Buyer buyer = new Buyer(0, login, password, email, 2);
        DAO dao = DAO.getDAO();
        dao.buyerDAO.create(buyer);
        if (buyer.getId() > 0){
            return Actions.LOGIN.jsp;
        }
        else {
            req.setAttribute(Msg.MESSAGE, "Ошибка добавления пользователя");
            return Actions.SIGNUP.jsp;
        }
    }
}
