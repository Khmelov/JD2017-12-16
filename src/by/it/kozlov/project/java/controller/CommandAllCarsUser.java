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
import java.text.ParseException;
import java.util.List;

public class CommandAllCarsUser extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.setAttribute(Message.MESSAGE, "Войдите чтобы просмотреть объявления");
            return Actions.LOGIN.command;
        }
        List<Car> cars = DAO.getDAO().car.getAll(String.format("WHERE usersID=%d", user.getId()));
        request.setAttribute("cars", cars);
        List<Brand> brands = DAO.getDAO().brand.getAll();
        request.setAttribute("brands", brands);
        if (FormUtil.isPost(request)) {
            Car car;
            if (request.getParameter("Delete") != null) {
                car = new Car();
                car.setId(Integer.parseInt(request.getParameter("Delete")));
                DAO.getDAO().car.delete(car);
                request.setAttribute(Message.MESSAGE, "Автомобиль удалён");
                cars = DAO.getDAO().car.getAll(String.format("WHERE usersID=%d", user.getId()));
                request.setAttribute("cars", cars);
                return null;
            } else {
                try {
                    if (request.getParameter("Price") != "") {
                        car = new Car(0,
                                Integer.parseInt(request.getParameter("Brand")),
                                FormUtil.getString(request.getParameter("Model"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                                FormUtil.getString(request.getParameter("CarClass"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                                Double.parseDouble(request.getParameter("Price")),
                                Integer.parseInt(request.getParameter("Year")),
                                user.getId()
                        );
                    } else {
                        request.setAttribute(Message.MESSAGE, "Введите цену");
                        return null;
                    }
                } catch (ParseException e) {
                    request.setAttribute(Message.MESSAGE, "Введены недопустимые символы");
                    return null;
                }
                car.setId(Integer.parseInt(request.getParameter("Submit")));
                DAO.getDAO().car.update(car);
                request.setAttribute(Message.MESSAGE, "Данные изменены");
                cars = DAO.getDAO().car.getAll(String.format("WHERE usersID=%d", user.getId()));
                request.setAttribute("cars", cars);
                return null;
            }
        } else {
            return null;
        }
    }
}

