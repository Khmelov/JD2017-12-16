package by.it.sendetskaya.project.java.controller;

import by.it.sendetskaya.project.java.DAO.DAO;
import by.it.sendetskaya.project.java.entity.Basket;
import by.it.sendetskaya.project.java.entity.Buyer;
import by.it.sendetskaya.project.java.entity.Good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

class CommandIndex extends Action {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("buyer");   //извлекаем из сессии покупателя
        Buyer buyer;
        if (o!=null){
            buyer=(Buyer) o;
        }
        else
            return Actions.LOGIN.command;

        List<Good> goods=new ArrayList<>();

        //если нажата кнопка "Поиск"
        if (req.getParameter("searchBtn")!= null ) {

            String nameSearch=FormUtil.getString(req,"searchInput", "[\\wА-Яа-я]+");

            //выводит список товаро только по части слова Поиска
            goods=DAO.getDAO().goodDAO.getAll(" WHERE Name LIKE '%"+nameSearch+"%'");

            req.setAttribute("goods",goods);

            req.setAttribute(Msg.ERROR, "товар по Вашему поиску найден!");
            return null;

        }
        else
        {
            //выводит весь список товаров
            goods = DAO.getDAO().goodDAO.getAll();
            req.setAttribute("goods",goods);
        }


        //если нажата кнопка "В корзину"
        if (req.getParameter("Update")!= null ) {
            int idGood = FormUtil.getInt(req, "ID");
            double price=FormUtil.getDouble(req,"Price");
            String name=goods.get(0).getName();
            int id=0;
            int quantity= 1;
            int fk_buyers=buyer.getId();
            int fk_goods=idGood;

            double sum= quantity*price;

            Basket basket=new Basket(id,quantity,sum,fk_buyers,fk_goods);
            DAO.getDAO().basketDAO.create(basket);

            req.setAttribute(Msg.ERROR, "товар " + name + " добавлен в корзину");
            return null;


        }
        return null;
    }
}