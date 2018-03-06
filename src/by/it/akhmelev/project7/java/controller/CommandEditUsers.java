package by.it.akhmelev.project7.java.controller;

import by.it.akhmelev.project7.java.dao.DAO;
import by.it.akhmelev.project7.java.entity.Ad;
import by.it.akhmelev.project7.java.entity.Role;
import by.it.akhmelev.project7.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandEditUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {

        if (FormUtil.isPost(req)){
            int id = FormUtil.getInt(req, "id");
            String login = FormUtil.getString(req, "Login", ".+");
            String email = FormUtil.getString(req, "Email", ".+");
            String password = FormUtil.getString(req, "Password", ".+");
            int fk_roles = FormUtil.getInt(req, "fk_roles");
            User user=new User(id,login,email,password,fk_roles);
            if (req.getParameter("Update")!=null){
                DAO.getDAO().userDAO.update(user);
            }
            else if (req.getParameter("Delete")!=null){
                DAO.getDAO().userDAO.delete(user);
            }
        }
        List<User> users = DAO.getDAO().userDAO.getAll("");
        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
        req.setAttribute("users",users);
        req.setAttribute("roles",roles);
        return null;
    }
}
