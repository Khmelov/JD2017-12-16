package by.it.kozlov.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandLogout extends Action {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        return Actions.LOGIN.command;
    }
}
