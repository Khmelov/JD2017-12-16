package by.it.vshelukhin.jd03_05.java;

import by.it.vshelukhin.jd03_05.java.dao.DAO;
import by.it.vshelukhin.jd03_05.java.dao.beans.Work;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandRedPrice extends Action {
    @Override
    Action execute(HttpServletRequest request) throws Exception {
        DAO dao = DAO.getDAO();

        if (FormUtil.isPost(request)){
            int id = FormUtil.getInt(request,"id");
            String name = FormUtil.getString(request.getParameter("name"), ".+");
            double price = FormUtil.getDouble(request,"price");
            Work work = new Work(id, name, price);
            if (request.getParameter("update")!=null){
                dao.workDAO.update(work);
            }
            else if (request.getParameter("delete")!=null){
                dao.workDAO.delete(work);
            }
            else if (request.getParameter("create")!=null){
                dao.workDAO.create(work);
            }
        }

        List<Work> worksAll = dao.workDAO.readAll("");
        request.setAttribute("wrk",worksAll);

        return null;
    }
}
