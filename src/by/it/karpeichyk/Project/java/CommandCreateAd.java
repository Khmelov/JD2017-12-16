package by.it.karpeichyk.Project.java;

import by.it.karpeichyk.Project.java.dao.BEAN.Ad;
import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 04.03.2018.
 */
public class CommandCreateAd extends  AbstractAction {
    @Override
    AbstractAction execute(HttpServletRequest req) throws Exception {
       HttpSession session = req.getSession();
        Object o = session.getAttribute("user");

       User user;
      if (o != null) {
            user = (User) o;
      } else
         return Action.LOGIN.command;
        if (FormUtil.isPost(req)) {
            int id = 0;
            String description = FormUtil.getString(req, "Description", ".*");
            int carrying = FormUtil.getInt(req, "Carrying");
            int volume = FormUtil.getInt(req, "Volume");
            String tariff = FormUtil.getString(req, "Tariff", ".*");
           int fk_users = user.getId();
            Ad ad = new Ad(id,description,carrying,volume,tariff,fk_users);
            MyDAO.getMyDAO().myAdDAO.create(ad);
            return null;
        } else
            return null;
    }
}




