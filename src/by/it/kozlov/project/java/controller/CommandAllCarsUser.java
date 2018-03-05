package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.Car;
import by.it.kozlov.project.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandAllCarsUser extends Action {
    @Override
    Action execute(HttpServletRequest request) throws ParseException, SQLException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else {
            request.setAttribute(Message.MESSAGE,"Войдите чтобы просмотреть объявления");
            return Actions.LOGIN.command;
        }
        List<Car> cars = DAO.getDAO().car.getAll(String.format("WHERE usersID=%d", user.getId()));
        request.setAttribute("cars", cars);
        return null;
    }
}
