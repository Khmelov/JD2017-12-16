package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Publication;
import by.it.sevashko.project.java.entities.Subscription;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public class CommandCreateSubscription extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, ParseException {
        User user = FormUtil.getUser(req);
        if (user == null){
            return Actions.LOGIN.getCommand();
        }

        int publicationId = FormUtil.getInt(req, "index");
        Publication publication = DAO.getDAO().publicationDAO.read(publicationId);
        if (req.getParameter("Subscribe") != null){
            int period = FormUtil.getInt(req, "period");
            int copies = Math.round(publication.getPeriodicity()/6) * period;
            Date start_subscription = FormUtil.getDate(req, "start_subscription");
            LocalDate localDate = start_subscription.toLocalDate();
            Date end_subscription = Date.valueOf(localDate.plusMonths(period).toString());
            double price = publication.getPrice() * period;
            Subscription subscription = new Subscription(0, user.getId(), publicationId,
                    copies, period, start_subscription, end_subscription, price);
            DAO.getDAO().subscriptionsDAO.create(subscription);
            return Actions.SHOWSUBSCRIPTIONS.command;
        }
        int[] options = new int[5];
        for (int i = 0; i < 5; i++) {
            options[i] = (i+1)*publication.getMinPeriod();
        }
        req.setAttribute("options", options);
        req.setAttribute("publication", publication);
        if (FormUtil.isPost(req)){

        }
        return null;
    }
}
