package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.dao.beans.Ad;
import by.it.krasutski.project.java.dao.beansDAO.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateAd implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) throws Exception {
        if (FormUtil.isPost(req)){
            return Actions.CREATEAD.jsp;
        }
        Ad ad = new Ad(0,
                FormUtil.getString(req.getParameter("Title"), ".+"),
                FormUtil.getString(req.getParameter("SmallDesc"), ".+"),
                FormUtil.getString(req.getParameter("Description"), ".+"),
                Integer.parseInt(req.getParameter("Price")),
                1, Integer.parseInt(req.getParameter("category_ID"))
        );
        DAO dao = DAO.getDAO();
        dao.adDAO.create(ad);
        if (ad.getID() > 0) {
            req.setAttribute(Msg.MESSAGE, "Ad created.");
            return Actions.MYADS.jsp;
        } else {
            req.setAttribute(Msg.ERROR, "Can't create ad.");
            return Actions.CREATEAD.jsp;
        }
    }
}
