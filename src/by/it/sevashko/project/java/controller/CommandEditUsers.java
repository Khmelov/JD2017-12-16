package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Role;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandEditUsers extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, ParseException {
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
            String login = FormUtil.checkValue(req.getParameter("login"), Patterns.Login);
            String password = FormUtil.checkValue(req.getParameter("password"), Patterns.PASSWORD);
            String name = FormUtil.checkValue(req.getParameter("name"), Patterns.NAME);
            String lastName = FormUtil.checkValue(req.getParameter("lastName"), Patterns.NAME);
            String email = FormUtil.checkValue(req.getParameter("email"), Patterns.EMAIL);
            int fk_role = FormUtil.getInt(req, "fk_role");
            User userR = new User(id, login, password, name, lastName, email, fk_role);
            if (req.getParameter("Add") != null){
                DAO.getDAO().userDAO.create(userR);
                req.setAttribute(Msg.MESSAGE, "Пользователь зарегистрирован");
            }
            else if (req.getParameter("Update")!=null){
                DAO.getDAO().userDAO.update(userR);
                req.setAttribute(Msg.MESSAGE, "Пользователь обнавлен");
            }
            else if (req.getParameter("Delete")!=null){
                DAO.getDAO().userDAO.delete(userR);
                req.setAttribute(Msg.MESSAGE, "Пользователь удален");
            }
        }
        DAO dao = DAO.getDAO();
        List<User> users = dao.userDAO.getALL("");
        List<Role> roles = dao.roleDAO.getALL("");
        req.setAttribute("users", users);
        req.setAttribute("roles", roles);
        return null;
    }
}
