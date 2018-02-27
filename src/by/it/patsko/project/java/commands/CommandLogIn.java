package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.BuyerDAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandLogIn implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) throws SQLException {
        if (!FormUtil.isPost(req)) return Actions.LOGIN.jsp;
        try {
            String testLogin= FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
            String testPassword= FormUtil.getString(req.getParameter("Password"), Pattern.LOGIN);
            Buyer buyer=new BuyerDAO().read(new BuyerDAO().read(testLogin,testPassword));
            LogInBuyer.getInstance(buyer);

            req.setAttribute(Msg.BUYER,LogInBuyer.currentBuyer.getLogin());

//            req.setAttribute(Msg.MESSAGE,"testLogin="+testLogin+"\ntestPassword="+testPassword);
            req.setAttribute(Msg.MESSAGE,"testLogin="+testLogin+"\ntestPassword="+testPassword+"\ncurrentBuyer="+LogInBuyer.currentBuyer);
        } catch (ParseException e) {
            req.setAttribute(Msg.ERROR,e.getMessage()+"\n");
        }
        return Actions.LOGIN.jsp;
//        return null;
    }
}
