package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Role;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandEditUsers extends Command {
    @Override
    Command execute(HttpServletRequest req) throws Exception {
        DAO dao=DAO.getDAO();
        User userInSession = Util.findInSession(req, "user");
        if (userInSession == null)
            return Actions.LOGIN.command;
        if (Util.isPost(req)){
            int id = Util.frmInt(req, "id");
            String login = Util.frmString(req, "Login", ".+");
            String email = Util.frmString(req, "Email", ".+");
            String password = Util.frmString(req, "Password", ".+");
            int fk_roles = Util.frmInt(req, "fk_roles");

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
