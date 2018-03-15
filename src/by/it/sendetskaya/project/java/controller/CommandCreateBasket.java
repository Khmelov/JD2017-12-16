package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Basket;
import by.it.sendetskaya.project.java.entity.Buyer;
import by.it.sendetskaya.project.java.entity.Good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class CommandCreateBasket extends Action {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        double sumReady=0;
        List<Double>sumList=new ArrayList<>();
        HttpSession session = req.getSession();
        Object o = session.getAttribute("buyer");
        Buyer buyer;
        if (o!=null){
            buyer=(Buyer) o;
        }
        else
            return Actions.LOGIN.command;



        if (FormUtil.isPost(req))
            {
                int idGood = FormUtil.getInt(req, "FK_goods");
                Good good = DAO.getDAO().goodDAO.getAll("where ID='" + idGood + "'").get(0);

                int id = FormUtil.getInt(req, "ID");
                int quantity = FormUtil.getInt(req, "Quantity");
                double sum=FormUtil.getDouble(req,"Sum");
                sum=quantity*good.getPrice();
                sumList.add(sum);
                int fk_buyers=buyer.getId();
                int fk_goods=idGood;


                Basket basket=new Basket(id,quantity,sum,fk_buyers,fk_goods);


                if (req.getParameter("Update") != null) {
                    DAO.getDAO().basketDAO.update(basket);
                } else if (req.getParameter("Delete") != null) {
                    DAO.getDAO().basketDAO.delete(basket);
                }


            }

        List<Basket> baskets = DAO.getDAO().basketDAO.getAll(
                "where fk_buyers='" + buyer.getId() + "'"
        );
        List<Good> goods=DAO.getDAO().goodDAO.getAll();

        req.setAttribute("baskets", baskets);
        req.setAttribute("goods", goods);

        if (goods.size()<1)
            req.setAttribute(Msg.ERROR, "Ваша корзина пуста!");

        Iterator<Basket> iterator=baskets.iterator();
        while (iterator.hasNext())
        {
            sumReady+=iterator.next().getSum();
        }

        if (req.getParameter("ready") != null) {
            String sumOutput=String.format("Ваш заказ принят, сумма к оплате: %5.2f рублей", sumReady);
            req.setAttribute(Msg.MESSAGE, sumOutput);
        }

        return null;


    }
}