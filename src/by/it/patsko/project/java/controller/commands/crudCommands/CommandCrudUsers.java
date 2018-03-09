package by.it.patsko.project.java.controller.commands.crudCommands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.controller.Pattern;
import by.it.patsko.project.java.controller.commands.ActionCommand;
import by.it.patsko.project.java.controller.commands.CommandError;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Catalog;
import by.it.patsko.project.java.dao.beens.Role;
import by.it.patsko.project.java.dao.beens.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class CommandCrudUsers extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {
            int id = FormUtil.getInt(req.getParameter("id"));
            String login = FormUtil.getString(req.getParameter("login"), Pattern.LOGIN);
            String password = FormUtil.getString(req.getParameter("password"), Pattern.PASSWORD);
            String email = FormUtil.getString(req.getParameter("email"), Pattern.EMAIL);
            int roles_id = FormUtil.getInt(req.getParameter("roles_id"));
            User user = new User(id, login, password, email, roles_id);

            if (req.getParameter("Update") != null) {
                DAO.getDAO().userDAO.update(user);
            } else if (req.getParameter("Delete") != null) {
                if (((User) req.getSession().getAttribute(Msg.USER)).getRoles_id() != roles_id) {
                    DAO.getDAO().userDAO.delete(user);
                } else {
                    CommandError.errorMassage = "Вы не можете удалить себя";
                    CommandError.errorDetails = "";
                    return Actions.ERROR.command;
                }
            } else if (req.getParameter("Create") != null) {
                DAO.getDAO().userDAO.create(user);
            }
        }
        List<User> users = DAO.getDAO().userDAO.getAll("");
        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
        req.setAttribute(Msg.USERS, users);
        req.setAttribute(Msg.ROLES, roles);
        return Actions.CRUDUSERS.command;
    }
}
