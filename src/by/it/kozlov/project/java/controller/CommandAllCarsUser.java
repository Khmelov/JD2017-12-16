package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.Brand;
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
    Action execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
            if (user == null) {
                request.setAttribute(Message.MESSAGE, "Войдите чтобы просмотреть объявления");
                return Actions.LOGIN.command;
            }
        List<Car> cars = DAO.getDAO().car.getAll(String.format("WHERE usersID=%d", user.getId()));
        request.setAttribute("cars", cars);
        List<Brand> brands = DAO.getDAO().brand.getAll();
        request.setAttribute("brands", brands);
        return null;
    }
}
