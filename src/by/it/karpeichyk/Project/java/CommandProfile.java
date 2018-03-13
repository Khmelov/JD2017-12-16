package by.it.karpeichyk.Project.java;

import by.it.karpeichyk.Project.java.dao.BEAN.Ad;
import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 09.03.2018.
 */
class CommandProfile extends AbstractAction {
    @Override
    AbstractAction execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o !=null) {
            user = (User) o;
        } else
        return Action.LOGIN.command;

        if (FormUtil.isPost(req)){
            String login = FormUtil.getString(req,"Login", ".+");
            String pasword = FormUtil.getString(req,"Pasword", ".+");
            user.setLogin(login);
            user.setPasword(pasword);
            MyDAO.getMyDAO().myUserDAO.update(user);
        }
        List <Ad> ads = MyDAO.getMyDAO().myAdDAO.getAll(
                "where fk_users='" + user.getId() + "'");
        req.setAttribute("ads", ads);
        return null;
    }
}

