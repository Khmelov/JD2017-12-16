package by.it.patsko.project.java.controller.commands.crudCommands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.controller.commands.ActionCommand;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudRoles extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {
            Role role=new Role(FormUtil.getInt(req.getParameter("id")),
                    FormUtil.getString(req.getParameter("role")));
            if(req.getParameter("Update")!=null){
                DAO.getDAO().roleDAO.update(role);
            }
            if(req.getParameter("Delete")!=null){
                DAO.getDAO().roleDAO.delete(role);
            }
            if(req.getParameter("Create")!=null){
                DAO.getDAO().roleDAO.create(role);

            }
        }
        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
        req.setAttribute(Msg.ROLES, roles);
        return Actions.CRUDROLES.command;
    }
}
