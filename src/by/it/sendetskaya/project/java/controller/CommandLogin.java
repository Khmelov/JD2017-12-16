package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Buyer;
import by.it.sendetskaya.project.java.filters.Cookies;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandLogin extends Action{
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {

        if (!FormUtil.isPost(req))
            return null;

        if (req.getParameter("loginID").equals("")) {
            req.setAttribute(Msg.MESSAGE, "Введите имя пользователя и пароль");
            return Actions.LOGIN.command;
        }

        String nickname= FormUtil.getString(req,"loginID", "[\\wА-Яа-я]+");
        //String email = FormUtil.getString(req,"Email", "[\\w]+[@]{1}[a-z]{3,6}\\.[a-z]{2,3}");
        String password=FormUtil.getString(req,"passwordLoginID","[\\w]+");

        DAO dao=DAO.getDAO();
        List<Buyer> list=dao.buyerDAO.getAll(" WHERE Nickname='"+nickname+"' and Password='"+password+"'");

        if (list.size()>0) {
            req.setAttribute(Msg.MESSAGE, "пользователь " + nickname + " найден");
            HttpSession session = req.getSession();
            session.setAttribute("buyer",list.get(0));
           // Cookies.setCookie(resp, list.get(0));
            return null;
        }
        else {
            req.setAttribute(Msg.ERROR, "пользователь " + nickname + " НЕ найден");
            req.setAttribute(Msg.ERROR, "Неверный логин или пароль");
            return Actions.LOGIN.command;
        }
    }
}