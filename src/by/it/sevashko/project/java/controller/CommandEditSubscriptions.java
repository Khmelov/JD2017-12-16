package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Subscription;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CommandEditSubscriptions extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException{
        User user = FormUtil.getUser(req);
        if (user != null){
            //проверка на администратора
            if (!FormUtil.isAdministrator(user)) {
                req.getSession().setAttribute(Msg.MESSAGE, "Вы не администратор");
                return Actions.ERROR.command;
            }
        }
        else return Actions.LOGIN.getCommand();

        if (FormUtil.isPost(req)){
            int id;
            try {
                id = FormUtil.getInt(req, "id");
            } catch (NumberFormatException e){
                id = 0;
            }
            req.setAttribute(Msg.MESSAGE, "Проверка полей");
            int userP = FormUtil.getInt(req, "user");
            int publication = FormUtil.getInt(req, "publication");
            int copies = FormUtil.getInt(req, "copies");
            int period = FormUtil.getInt(req, "period");
            Date start_subscription = FormUtil.getDate(req,"start_subscription");
            Date end_subscription = FormUtil.getDate(req,"end_subscription");
            double price = FormUtil.getDouble(req, "price");
            Subscription subscription = new Subscription(id, userP, publication, copies, period, start_subscription, end_subscription, price);
            if (req.getParameter("Add") != null){
                DAO.getDAO().subscriptionsDAO.create(subscription);
                req.setAttribute(Msg.MESSAGE, "Подписка создана");
            }
            else if (req.getParameter("Update")!=null){
                DAO.getDAO().subscriptionsDAO.update(subscription);
                req.setAttribute(Msg.MESSAGE, "Подписка изменена");
            }
            else if (req.getParameter("Delete")!=null){
                DAO.getDAO().subscriptionsDAO.delete(subscription);
                req.setAttribute(Msg.MESSAGE, "Подписка удалена");
            }
        }
        List<Subscription> subscriptions = DAO.getDAO().subscriptionsDAO.getALL("");
        req.setAttribute("subscriptions", subscriptions);
        return null;
    }
}
