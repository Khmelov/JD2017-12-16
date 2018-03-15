package by.it.akhmelev.project6.java.controller;


import by.it.akhmelev.project6.java.controller.constants.Pattern;
import by.it.akhmelev.project6.java.dao.DAO;
import by.it.akhmelev.project6.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandEditUsers extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        try {
            if (FormUtil.isPost(req)) {
                if (req.getParameter("Update") != null) {
                    User user = new User(
                            FormUtil.getInt(req, "id"),
                            FormUtil.getString(req, "login", Pattern.LOGIN),
                            FormUtil.getString(req, "password", Pattern.PASSWORD),
                            FormUtil.getString(req, "email", Pattern.EMAIL),
                            FormUtil.getInt(req,"fk_Role")
                            );
                    dao.userDAO.update(user);
                }
                if (req.getParameter("Delete") != null) {
                    User user = new User();
                    user.setId(FormUtil.getInt(req, "id"));
                    dao.userDAO.delete(user);
                }
            }
            //List<Role> roles = dao.role.getAll("");
            List<User> users = dao.userDAO.getAll("");
            //req.getServletContext().setAttribute("roles", roles);
            req.setAttribute("users", users);
        } catch (ParseException e) {
            req.setAttribute(Msg.ERROR,e);
            e.printStackTrace();
        } catch (SQLException e) {
            req.setAttribute(Msg.ERROR,e);
            e.printStackTrace();
        }
        return null;
    }
}
