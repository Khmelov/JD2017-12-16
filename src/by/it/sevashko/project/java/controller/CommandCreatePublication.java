package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Publication;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandCreatePublication extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws ParseException, SQLException {
        HttpSession session = req.getSession();
        Object object = session.getAttribute("user");
        if (object != null){
            //todo только для администратора
            User user = (User) object;
        }
        else return Actions.LOGIN.getCommand();

        if (!FormUtil.isPost(req)) return null;

        req.setAttribute(Msg.MESSAGE, "Проверка полей");
        String name = FormUtil.checkValue(req.getParameter("name"), Patterns.NAME);
        int periodicity = FormUtil.getInt(req, "periodicity");
        int minPeriod = FormUtil.getInt(req, "minPeriod");
        double price = FormUtil.getDouble(req, "price");
        System.out.println("Hello");

        req.setAttribute(Msg.MESSAGE, "Создание объекта издания");
        Publication publication = new Publication(0, name, periodicity, minPeriod, price);

        req.setAttribute(Msg.MESSAGE, "Получаем DAO");
        DAO dao = DAO.getDAO();

        req.setAttribute(Msg.MESSAGE, "Запись в базу данных");
        boolean isCreated = dao.publicationDAO.create(publication);

        if (isCreated) {
            req.setAttribute(Msg.MESSAGE, "Издание добавлено");
            return null;
        }
        else
        {
            req.setAttribute(Msg.MESSAGE,"Ошибка добавления издания");
            return null;
        }
    }
}
