package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.Car;
import by.it.kozlov.project.java.entity.User;
import by.it.kozlov.project.java.filters.CookiesUser;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class CommandAllCarsUser extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse resp) throws SQLException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        User user = null;
        if (o != null) {
            user = (User) o;
        } else if (o == null) {
            user = CookiesUser.getCookie(request);
            if (user == null) {
                request.setAttribute(Message.MESSAGE, "Войдите чтобы просмотреть объявления");
                return Actions.LOGIN.command;
            }
        }
        List<Car> cars = DAO.getDAO().car.getAll(String.format("WHERE usersID=%d", user.getId()));
        request.setAttribute("cars", cars);
        return null;
    }
}
