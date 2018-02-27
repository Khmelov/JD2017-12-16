package by.it.kozlov.project.java;

import by.it.kozlov.project.java.dao.beans.Car;
import by.it.kozlov.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandAddCar implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws ParseException, SQLException {
        if (!FormUtil.isPost(request)) {
            return Actions.ADDCAR.jsp;
        }
        Car car = new Car(0,
                Integer.parseInt(request.getParameter("Brand")),
                FormUtil.getString(request.getParameter("Model"), ".+"),
                FormUtil.getString(request.getParameter("CarClass"), ".+"),
                Double.parseDouble(request.getParameter("Price")),
                Integer.parseInt(request.getParameter("Year")),
                1

        );
        DAO dao = DAO.getDAO();
        if (dao.car.create(car)) {
            request.setAttribute(Message.MESSAGE, "Автомобиль добавлен");
            return Actions.ADDCAR.jsp;
        } else {
            request.setAttribute(Message.MESSAGE, "Ошибка добавления машины");
            return Actions.ADDCAR.jsp;
        }
    }
}
