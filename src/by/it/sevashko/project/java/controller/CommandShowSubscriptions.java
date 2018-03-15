package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Publication;
import by.it.sevashko.project.java.entities.Subscription;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CommandShowSubscriptions extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        User user = FormUtil.getUser(req);
        if (user == null){
            return Actions.LOGIN.getCommand();
        }

        DAO dao = DAO.getDAO();
        if (FormUtil.isPost(req)){
            if (req.getParameter("Delete") != null){
                int id = FormUtil.getInt(req,"Delete");
                Subscription subscription = dao.subscriptionsDAO.read(id);
                DAO.getDAO().subscriptionsDAO.delete(subscription);
                req.setAttribute(Msg.MESSAGE, "Подписка удалена");
            }
        }
        List<Subscription> subscriptions = dao.subscriptionsDAO.getALL(String.format("WHERE user='%s'", user.getId()));
        HashMap<Integer, String> publicationsNames = new HashMap<>();
        for (Subscription sub : subscriptions){
            Publication publication = dao.publicationDAO.read(sub.getPublication());
            String publicationName = publication.getName();
            publicationsNames.put(sub.getPublication(), publicationName);
        }
        req.setAttribute("subscriptions", subscriptions);
        req.setAttribute("publicationsNames", publicationsNames);
        return null;
    }
}
