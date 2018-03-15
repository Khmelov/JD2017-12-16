package by.it.karpeichyk.Project.java;

import by.it.karpeichyk.Project.java.dao.BEAN.Ad;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by user on 05.03.2018.
 */
class CommandIndex extends  AbstractAction {
    @Override
    AbstractAction execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = MyDAO.getMyDAO().myAdDAO.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
