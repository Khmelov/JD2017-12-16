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

public class CommandProfile extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Msg.USER);
        if (user != null) {
            if (FormUtil.isPost(req)) {
                String login = FormUtil.getString(req.getParameter("newLogin"), Pattern.LOGIN);
                if (login != null) {
                    user.setLogin(login);
                    new UserDAO().update(user);
                    session.setAttribute(Msg.USER, user);
                    return Actions.PROFILE.command;
                } else req.setAttribute(Msg.MESSAGE, "login==null");

                String password = FormUtil.getString(req.getParameter("newPassword"), Pattern.PASSWORD);
                if (password != null) {
                    user.setPassword(password);
                    new UserDAO().update(user);
                    session.setAttribute(Msg.USER, user);
                    return Actions.PROFILE.command;
                } else req.setAttribute(Msg.MESSAGE, "password==null");
            }
            req.setAttribute(Msg.MESSAGE, getCookies(req));
            return Actions.PROFILE.command;
        } else return Actions.LOGIN.command;
    }

    private String getCookies(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("loginCookie") || cookies[i].getName().equals("passwordCookie"))
                sb.append("<br>").append("Encoded: ").append(cookies[i].getName()).append("=").append(cookies[i].getValue())
                        .append("<br>").append("Decoded: ").append(cookies[i].getName()).append("=").append(decodeCookie(cookies[i].getValue())).append("<br>");
        }
        return sb.toString();
    }

    String decodeCookie(String cookieValue) {
        //в файле deploy.xml нужно обязательно прописать
        // <fileset dir="${local.lib.dir}" includes="commons-codec-1.10.jar"/>
        return new String(Base64.decodeBase64(cookieValue.getBytes()));
    }
}
