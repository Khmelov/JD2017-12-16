package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.entity.Car;
import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandAddCar extends Action {
    @Override
    public Action execute(HttpServletRequest request) throws ParseException, SQLException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else {
            return Actions.LOGIN.command;
        }
        if (FormUtil.isPost(request)) {
            Car car = new Car(0,
                    Integer.parseInt(request.getParameter("Brand")),
                    FormUtil.getString(request.getParameter("Model"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                    FormUtil.getString(request.getParameter("CarClass"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                    Double.parseDouble(request.getParameter("Price")),
                    Integer.parseInt(request.getParameter("Year")),
                    user.getId()
            );
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
