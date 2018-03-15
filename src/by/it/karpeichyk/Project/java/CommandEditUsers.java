package by.it.karpeichyk.Project.java;

import by.it.karpeichyk.Project.java.dao.BEAN.Role;
import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by user on 09.03.2018.
 */
class CommandEditUsers extends  AbstractAction {
    @Override
    AbstractAction execute(HttpServletRequest req) throws Exception {
        if (FormUtil.isPost(req)){
            int id = FormUtil.getInt(req, "id");
            String login = FormUtil.getString(req, "Login", ".+");
            String email = FormUtil.getString(req, "Email", ".+");
            String password = FormUtil.getString(req, "Pasword", ".+");
            int fk_roles = FormUtil.getInt(req, "fk_roles");
            User user=new User(id,login,email,password,fk_roles);
            if (req.getParameter("Update")!=null){
                MyDAO.getMyDAO().myUserDAO.update(user);
            }
            else if (req.getParameter("Delete")!=null){
                MyDAO.getMyDAO().myUserDAO.delete(user);
            }
        }
        List<User> users = MyDAO.getMyDAO().myUserDAO.getAll("");
        List<Role> roles = MyDAO.getMyDAO().myRoleDAO.getAll("");
        req.setAttribute("users",users);
        req.setAttribute("roles",roles);
        return null;
    }
}

