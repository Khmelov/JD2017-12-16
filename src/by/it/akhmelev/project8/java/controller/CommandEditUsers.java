package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Role;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandEditUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        DAO dao=DAO.getDAO();
        User userInSession = Util.findInSession(req, User.class);
        if (userInSession == null)
            return Actions.LOGIN.command;
        if (Util.isPost(req)){
            int id = Util.getInt(req, "id");
            String login = Util.getString(req, "Login", ".+");
            String email = Util.getString(req, "Email", ".+");
            String password = Util.getString(req, "Password", ".+");
            int fk_roles = Util.getInt(req, "fk_roles");

            User user=new User(id,login,email,password,fk_roles);

            if (req.getParameter("Update")!=null){
                dao.user.update(user);
            }
            else if (req.getParameter("Delete")!=null){
                dao.user.delete(user);
            }
        }
        List<User> users = dao.user.getAll("");
        List<Role> roles = dao.role.getAll("");
        req.setAttribute("users",users);
        req.setAttribute("roles",roles);
        return null;
    }
}
