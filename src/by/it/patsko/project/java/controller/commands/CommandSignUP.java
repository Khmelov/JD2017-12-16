package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.*;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandSignUP extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req) throws ParseException, SQLException {
        if (req.getSession().getAttribute(Msg.BUYER) != null) {
            CommandError.errorMassage="Вы уже вошли на сайт";
            CommandError.errorDetails="<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
        if (!FormUtil.isPost(req))
            return Actions.SIGNUP.command;
        String login =FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
        String email = FormUtil.getString(req.getParameter("Email"),Pattern.EMAIL);
        String password =FormUtil.getString(req.getParameter("Password"),Pattern.PASSWORD);
        Buyer buyer = new Buyer(0, login, password, email, 2);
        DAO dao = DAO.getDAO();
        dao.buyerDAO.create(buyer);
        if (buyer.getId() > 0){
            return Actions.LOGIN.command;
        }
        else {
            CommandError.errorMassage="Ошибка добавления пользователя";
            CommandError.errorDetails="<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
    }
}
