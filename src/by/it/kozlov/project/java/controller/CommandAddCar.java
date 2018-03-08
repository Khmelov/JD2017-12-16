package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.entity.Car;
import by.it.kozlov.project.java.dao.dao.DAO;
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
import java.text.ParseException;

public class CommandAddCar extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (FormUtil.isPost(request)) {
            Car car;
            try {
                car = new Car(0,
                        Integer.parseInt(request.getParameter("Brand")),
                        FormUtil.getString(request.getParameter("Model"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                        FormUtil.getString(request.getParameter("CarClass"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                        Double.parseDouble(request.getParameter("Price")),
                        Integer.parseInt(request.getParameter("Year")),
                        user.getId()
                );
            } catch (ParseException e) {
                request.setAttribute(Message.MESSAGE, "Введены недопустимые символы");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.car.create(car)) {
                request.setAttribute(Message.MESSAGE, "Автомобиль добавлен");
                return null;
            } else {
                request.setAttribute(Message.MESSAGE, "Ошибка добавления машины");
                return null;
            }
        } else {
            return null;
        }
    }
}
