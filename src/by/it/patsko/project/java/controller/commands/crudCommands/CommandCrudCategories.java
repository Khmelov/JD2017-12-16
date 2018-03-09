package by.it.patsko.project.java.controller.commands.crudCommands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.controller.commands.ActionCommand;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Catalog;
import by.it.patsko.project.java.dao.beens.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudCategories extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {
            Category category=new Category(FormUtil.getInt(req.getParameter("id")),
                    FormUtil.getString(req.getParameter("categoryName")),
                    FormUtil.getInt(req.getParameter("Catalog_id")));
            if(req.getParameter("Update")!=null){
                DAO.getDAO().categoryDAO.update(category);
            }else if(req.getParameter("Delete")!=null){
                DAO.getDAO().categoryDAO.delete(category);
            }else if(req.getParameter("Create")!=null){
                DAO.getDAO().categoryDAO.create(category);
            }
        }
        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        List<Catalog> catalogs = DAO.getDAO().catalogDAO.getAll("");
        req.setAttribute(Msg.CATEGORIES, categories);
        req.setAttribute(Msg.CATALOGS, catalogs);
        return Actions.CRUDCATEGORIES.command;
    }
}
