package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandSignUP implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws ParseException, SQLException {
        if (LogInBuyer.currentBuyer != null) {
            req.setAttribute(Msg.ERROR, "Вы уже вошли на сайт");
            req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace()));
            return Actions.ERROR.jsp;
        }
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
            req.setAttribute(Msg.ERROR, "Ошибка добавления пользователя");
            req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace()));
            return Actions.ERROR.jsp;
        }
    }
}
