package by.it.patsko.project.java.controller.commands.crudCommands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.controller.commands.ActionCommand;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Catalog;
import by.it.patsko.project.java.dao.beens.Category;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudListOfPurchases extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {
            ListOfPurchases listOfPurchases=new ListOfPurchases(FormUtil.getInt(req.getParameter("id")),
                    FormUtil.getInt(req.getParameter("users_id")),
                    FormUtil.getInt(req.getParameter("books_id")));
            if(req.getParameter("Update")!=null){
                DAO.getDAO().listOfPurchasesDAO.update(listOfPurchases);
            }else if(req.getParameter("Delete")!=null){
                DAO.getDAO().listOfPurchasesDAO.delete(listOfPurchases);
            }else if(req.getParameter("Create")!=null){
                DAO.getDAO().listOfPurchasesDAO.create(listOfPurchases);
            }
        }
        List<ListOfPurchases> listOfPurchases = DAO.getDAO().listOfPurchasesDAO.getAll("");
        req.setAttribute(Msg.LIST_OF_PURCHASES, listOfPurchases);
        return Actions.CRUDLISTOFPURCHASES.command;
    }
}
