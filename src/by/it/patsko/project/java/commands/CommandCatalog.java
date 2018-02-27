package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandCatalog implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws ParseException, SQLException {
            return Actions.CATALOG.jsp;
    }
}
