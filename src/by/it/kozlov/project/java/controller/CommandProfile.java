package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.entity.Brand;
import by.it.kozlov.project.java.entity.Car;
import by.it.kozlov.project.java.entity.City;
import by.it.kozlov.project.java.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Brand> brands = DAO.getDAO().brand.getAll();
        request.setAttribute("brands", brands);
        List<City> cities = DAO.getDAO().city.getAll();
        request.setAttribute("cities", cities);
        List<Role> roles = DAO.getDAO().role.getAll();
        request.setAttribute("roles", roles);
        return null;
    }
}
