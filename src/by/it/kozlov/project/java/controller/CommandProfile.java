package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.*;
import by.it.kozlov.project.java.filters.CookiesUser;

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

public class CommandProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        List<Brand> brands = DAO.getDAO().brand.getAll();
        request.setAttribute("brands", brands);
        List<City> cities = DAO.getDAO().city.getAll();
        request.setAttribute("cities", cities);
        List<Role> roles = DAO.getDAO().role.getAll();
        request.setAttribute("roles", roles);
        if (FormUtil.isPost(request)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            try {
                if (request.getParameter("Email") != "") {
                    user.setEmail(FormUtil.getString(request.getParameter("Email"),
                            "([A-Za-z0-9_]*)[@a-z0-9_\\.]+"));
                }
                if (request.getParameter("Password") != "") {
                    user.setPassword(FormUtil.getString(request.getParameter("Password"),
                            "[A-Za-z0-9_А-Яа-яЁё]+"));
                }
                if (request.getParameter("City") != "") {
                    user.setCityID(Integer.parseInt(request.getParameter("City")));
                }
                if (request.getParameter("address") != "") {
                    user.setAddress(FormUtil.getString(request.getParameter("address"),
                            "[A-Za-z0-9_А-Яа-яЁё., -]+"));

                }
                if (request.getParameter("phoneNumber") != "") {
                    user.setPhoneNumber(FormUtil.getString(request.getParameter("phoneNumber"),
                            "[0-9+]*"));

                }
            } catch (ParseException e) {
                request.setAttribute(Message.MESSAGE, "Введены недопустимые символы");
                return null;
            }
            DAO.getDAO().user.update(user);
            CookiesUser.setCookie(response, user);
            request.setAttribute(Message.MESSAGE, "Данные изменены");
        }
        return null;
    }
}
