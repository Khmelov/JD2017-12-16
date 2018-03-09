package by.it.patsko.project.java.controller.commands.crudCommands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.controller.commands.ActionCommand;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Catalog;
import by.it.patsko.project.java.dao.beens.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudCatalogs extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {
            Catalog catalog=new Catalog(FormUtil.getInt(req.getParameter("id")),
                    FormUtil.getString(req.getParameter("catalogName")));
            if(req.getParameter("Update")!=null){
                DAO.getDAO().catalogDAO.update(catalog);
            }else if(req.getParameter("Delete")!=null){
                DAO.getDAO().catalogDAO.delete(catalog);
            }else if(req.getParameter("Create")!=null){
                DAO.getDAO().catalogDAO.create(catalog);
            }
        }
        List<Catalog> catalogs = DAO.getDAO().catalogDAO.getAll("");
        req.setAttribute(Msg.CATALOGS, catalogs);
        return Actions.CRUDCATALOGS.command;
    }
}
