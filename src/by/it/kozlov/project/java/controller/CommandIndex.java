package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.Car;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Car> cars = DAO.getDAO().car.getAll();
        req.setAttribute("cars", cars);
        return null;
    }
}
