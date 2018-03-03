package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.dao.DAO;
import by.it.akhmelev.project6.java.entity.Ad;
import by.it.akhmelev.project6.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandCreateAD extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws ParseException, SQLException {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o!=null){
            user=(User)o;
        }
        else
            return Actions.LOGIN.command;
        //create or show form
        if (FormUtil.isPost(req)){
           int id=0;
           String description=FormUtil.getString(req,"Description",".*");
           String address=FormUtil.getString(req,"Address",".*");;
           int floor=FormUtil.getInt(req,"Floor");;
           int floors=FormUtil.getInt(req,"Floors");;
           int roomCount=FormUtil.getInt(req,"RoomCount");;
           double price=FormUtil.getDouble(req,"Price");;
           double area=FormUtil.getDouble(req,"Area");;
           int fk_users=user.getId();
           Ad ad=new Ad(id,description,address,floor,floors,roomCount,price,area,fk_users);
           DAO.getDAO().adDAO.create(ad);
           return null;
        }
        else
           return null;
    }
}
