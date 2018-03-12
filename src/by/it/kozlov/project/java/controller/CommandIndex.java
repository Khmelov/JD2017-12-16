package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.Body;
import by.it.kozlov.project.java.entity.Brand;
import by.it.kozlov.project.java.entity.Car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Car> cars = DAO.getDAO().car.getAll();
        request.setAttribute("cars", cars);
        List<Brand> brands = DAO.getDAO().brand.getAll();
        request.setAttribute("brands", brands);
        List<Body> bodies = DAO.getDAO().body.getAll();
        request.setAttribute("bodies", bodies);
        return null;
    }
}
