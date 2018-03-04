package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.entity.Car;
import by.it.kozlov.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandAddCar extends Action {
    @Override
    public Action execute(HttpServletRequest request) throws ParseException, SQLException {
        if (!FormUtil.isPost(request)) {
            return Actions.ADDCAR.command;
        }
        Car car = new Car(0,
                Integer.parseInt(request.getParameter("Brand")),
                FormUtil.getString(request.getParameter("Model"), "[A-Za-z0-9_А-Яа-яЁё]"),
                FormUtil.getString(request.getParameter("CarClass"), "[A-Za-z0-9_А-Яа-яЁё]"),
                Double.parseDouble(request.getParameter("Price")),
                Integer.parseInt(request.getParameter("Year")),
                1

        );
        DAO dao = DAO.getDAO();
        if (dao.car.create(car)) {
            request.setAttribute(Message.MESSAGE, "Автомобиль добавлен");
            return Actions.ADDCAR.command;
        } else {
            request.setAttribute(Message.MESSAGE, "Ошибка добавления машины");
            return Actions.ADDCAR.command;
        }
    }
}
