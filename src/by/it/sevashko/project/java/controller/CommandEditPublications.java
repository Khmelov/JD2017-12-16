package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Publication;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandEditPublications extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, ParseException {
        User user = FormUtil.getUser(req);
        if (user != null){
            //проверка на администратора
            if (!FormUtil.isAdministrator(user)) {
                req.setAttribute(Msg.MESSAGE, "Вы не администратор");
                return Actions.ERROR.command;
            }
        }
        else return Actions.LOGIN.getCommand();

        if (FormUtil.isPost(req)){
            int index;
            try {
                index = FormUtil.getInt(req, "index");
            } catch (NumberFormatException e){
                index = 0;
            }
            req.setAttribute(Msg.MESSAGE, "Проверка полей");
            String name = FormUtil.checkValue(req.getParameter("name"), Patterns.NAME);
            int periodicity = FormUtil.getInt(req, "periodicity");
            int minPeriod = FormUtil.getInt(req, "minPeriod");
            double price = FormUtil.getDouble(req, "price");
            Publication publication = new Publication(index, name, periodicity, minPeriod, price);
            if (req.getParameter("Add") != null){
                DAO.getDAO().publicationDAO.create(publication);
                req.setAttribute(Msg.MESSAGE, "Издание добалено");
            }
            else if (req.getParameter("Update")!=null){
                DAO.getDAO().publicationDAO.update(publication);
                req.setAttribute(Msg.MESSAGE, "Издание обновлено");
            }
            else if (req.getParameter("Delete")!=null){
                DAO.getDAO().publicationDAO.delete(publication);
                req.setAttribute(Msg.MESSAGE, "Издание удалено");
            }
        }
        List<Publication> publications = DAO.getDAO().publicationDAO.getALL("");
        req.setAttribute("publications", publications);
        return null;
    }
}
