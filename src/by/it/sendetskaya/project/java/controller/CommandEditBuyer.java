package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Buyer;
import by.it.sendetskaya.project.java.entity.Good;
import by.it.sendetskaya.project.java.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CommandEditBuyer extends Action {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (FormUtil.isPost(req)){
            int id = FormUtil.getInt(req, "ID");
            String nickname = FormUtil.getString(req,"Nickname", "[\\wА-Яа-я]+");

            String password = FormUtil.getString(req,"Password", "[\\w]+");
            String email = FormUtil.getString(req,"Email", "[\\w]+[@]{1}[a-z]{3,6}\\.[a-z]{2,3}");
            int role = FormUtil.getInt(req,"FK_roles");

            Buyer buyer=new Buyer(id,email,nickname,password,role);
            if (req.getParameter("Update")!=null){
                DAO.getDAO().buyerDAO.update(buyer);
            }
            else if (req.getParameter("Delete")!=null){
                DAO.getDAO().buyerDAO.delete(buyer);
            }
        }
        List<Buyer> buyers = DAO.getDAO().buyerDAO.getAll();
        List<Role> roles = DAO.getDAO().roleDAO.getAll();
        req.setAttribute("buyers",buyers);
        req.setAttribute("roles",roles);
        return null;
    }
}