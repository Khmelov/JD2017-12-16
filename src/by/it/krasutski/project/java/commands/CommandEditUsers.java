package by.it.krasutski.project.java.commands;


import by.it.krasutski.project.java.dao.DAO;
import by.it.krasutski.project.java.entity.Role;
import by.it.krasutski.project.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandEditUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {

        if (FormUtil.isPost(req)) {
            int id = FormUtil.getInt(req, "ID");
            String login = FormUtil.getString(req, "Login", Patterns.LOGIN);
            String email = FormUtil.getString(req, "Email", Patterns.EMAIL);
            String password = FormUtil.getString(req, "Password", Patterns.PASSWORD);
            String nickname = FormUtil.getString(req, "Nickname", Patterns.NICKNAME);
            String phonenumber = FormUtil.getString(req, "PhoneNumber", Patterns.PHONENUMBER);
            int roles_ID = FormUtil.getInt(req, "roles_ID");
            User user = new User(id, login, email, password, nickname, phonenumber, roles_ID);
            if (req.getParameter("Update") != null) {
                DAO.getDAO().userDAO.update(user);
            } else if (req.getParameter("Delete") != null) {
                DAO.getDAO().userDAO.delete(user);
            }
        }
        List<User> users = DAO.getDAO().userDAO.getAll("");
        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
        req.setAttribute("users", users);
        req.setAttribute("roles", roles);
        return null;
    }
}
