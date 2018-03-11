package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Ad;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = DAO.getDAO().ad.getAll("");
        req.setAttribute("adsSize",ads.size());
        String strStart=req.getParameter("start");
        int startAd=0;
        if (strStart!=null)
            startAd=Integer.parseInt(strStart);
        String where=String.format(" LIMIT %d, 10",startAd);
        ads= DAO.getDAO().ad.getAll(where);
        req.setAttribute("ads",ads);
        return null;
    }
}
