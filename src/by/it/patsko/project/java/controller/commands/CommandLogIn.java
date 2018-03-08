package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.*;
import by.it.patsko.project.java.dao.beanDao.BuyerDAO;
import by.it.patsko.project.java.dao.beens.Buyer;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLogIn extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        HttpSession session = req.getSession();
        if (session.getAttribute(Msg.BUYER) != null) {
            CommandError.errorMassage = "Вы уже вошли на сайт";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
        if (!FormUtil.isPost(req)) return Actions.LOGIN.command;

        String testLogin = FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
        String testPassword = FormUtil.getString(req.getParameter("Password"), Pattern.PASSWORD);
        try {
            Buyer buyer = new BuyerDAO().read(new BuyerDAO().read(testLogin, testPassword));
            session.setAttribute(Msg.BUYER, buyer);
            session.setMaxInactiveInterval(30);
            req.setAttribute(Msg.MESSAGE, "Залогинился пользователь" + buyer.getLogin());

            setCookies(resp, buyer);

        } catch (NullPointerException e) {
            CommandError.errorMassage = "Такого пользователя не существует";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(e.getStackTrace());
            return Actions.ERROR.command;
        }
        return Actions.PROFILE.command;
    }

    void setCookies(HttpServletResponse resp, Buyer buyer) {
        System.out.println(buyer.getLogin() + "\n" +
                buyer.getPassword());
        List<Cookie> cookies = new ArrayList<>(2);
        cookies.add(new Cookie("loginCookie", encodeCookie(buyer.getLogin())));
        cookies.add(new Cookie("passwordCookie", encodeCookie(buyer.getPassword())));
        cookies.get(0).setMaxAge(60);
        cookies.get(1).setMaxAge(60);
        resp.addCookie(cookies.get(0));
        resp.addCookie(cookies.get(1));
    }

    String encodeCookie(String cookieValue){
        //в файле deploy.xml нужно обязательно прописать
        // <fileset dir="${local.lib.dir}" includes="commons-codec-1.10.jar"/>
        return new String(Base64.encodeBase64(cookieValue.getBytes()));
    }
}
