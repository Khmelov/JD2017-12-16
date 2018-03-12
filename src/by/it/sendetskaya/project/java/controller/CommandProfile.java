package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Basket;
import by.it.sendetskaya.project.java.entity.Buyer;
import by.it.sendetskaya.project.java.entity.Good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandProfile extends Action {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("buyer");
        Buyer buyer;
        if (o!=null){
            buyer=(Buyer) o;
        }
        else
            return Actions.LOGIN.command;

        //обновление данных пользователя
        if (FormUtil.isPost(req)) {
            String nickname = FormUtil.getString(req,"Nickname", "[\\wА-Яа-я]+");
            //String email = FormUtil.getString(req,"email", "[\\w]+[@]{1}[a-z]{3,6}\\.[a-z]{2,3}");
            String password = FormUtil.getString(req,"Password", "[\\w]+");
            buyer.setNickname(nickname);
            //user.setEmail(email);
            buyer.setPassword(password);
            DAO.getDAO().buyerDAO.update(buyer);

        }

//        List<Good> goods = DAO.getDAO().goodDAO.getAll(
//                "where FK_buyers='" + buyer.getId() + "'"
//        );
//        req.setAttribute("goods", goods);

        List<Basket> baskets = DAO.getDAO().basketDAO.getAll(
                "where fk_buyers='" + buyer.getId() + "'"
        );
        req.setAttribute("baskets", baskets);
        return null;
    }
}