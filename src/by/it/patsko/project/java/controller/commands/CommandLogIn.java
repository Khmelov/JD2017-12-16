package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.*;
import by.it.patsko.project.java.dao.beanDao.UserDAO;
import by.it.patsko.project.java.dao.beens.User;
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
        if (session.getAttribute(Msg.USER) != null) {
            CommandError.errorMassage = "Вы уже вошли на сайт";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
        if (!FormUtil.isPost(req)) return Actions.LOGIN.command;

        String login = FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
        String password = FormUtil.getString(req.getParameter("Password"), Pattern.PASSWORD);
        try {
            User user = new UserDAO().read(new UserDAO().read(login, password));
            session.setAttribute(Msg.USER, user);
            session.setMaxInactiveInterval(30);
            req.setAttribute(Msg.MESSAGE, "Залогинился пользователь" + user.getLogin());

            setCookies(resp, user);

        } catch (NullPointerException e) {
            CommandError.errorMassage = "Такого пользователя не существует";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(e.getStackTrace());
            return Actions.ERROR.command;
        }
        return Actions.PROFILE.command;
    }

    void setCookies(HttpServletResponse resp, User user) {
        List<Cookie> cookies = new ArrayList<>(2);
        cookies.add(new Cookie("loginCookie", encodeCookie(user.getLogin())));
        cookies.add(new Cookie("passwordCookie", encodeCookie(user.getPassword())));
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
