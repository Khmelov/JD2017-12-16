package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

public class CommandSignup extends Action {

    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException {

        if (!FormUtil.isPost(req))
            return null;

        //req.setAttribute(Msg.MESSAGE, "Зарегистрируйтесь");
        String nickname = FormUtil.getString(req,"login", "[\\wА-Яа-я]+");
        String email = FormUtil.getString(req,"email", "[\\w]+[@]{1}[a-z]{3,6}\\.[a-z]{2,3}");
        String password = FormUtil.getString(req,"password", "[\\w]+");
       // int role = Integer.parseInt(FormUtil.getString(req,"role", "[1-2]"));

        Buyer buyer = new Buyer(0, email, nickname, password, 2);

        DAO dao = DAO.getDAO();

        dao.buyerDAO.create(buyer);

        if (buyer.getId() > 0){
            req.setAttribute(Msg.MESSAGE, "Пользователь зарегестрирован");
            HttpSession session = req.getSession();
            session.setAttribute("buyer", buyer);
            return Actions.LOGIN.command;
        }

        else {
            req.setAttribute(Msg.ERROR, "Ошибка добавления пользователя");
            return null;
        }

    }
}