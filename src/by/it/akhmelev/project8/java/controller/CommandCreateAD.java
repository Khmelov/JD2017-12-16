package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Ad;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

class CommandCreateAD extends Command {
    @Override
    Command execute(HttpServletRequest req) throws ParseException, SQLException {
        User userInSession = Util.findInSession(req, User.class);
        if (userInSession == null)
            return Actions.LOGIN.command;
        //create or show form
        if (Util.isPost(req)) {
            int id = 0;
            String description = Util.getString(req, "Description", ".*");
            String address = Util.getString(req, "Address", ".*");
            int floor = Util.getInt(req, "Floor");
            int floors = Util.getInt(req, "Floors");
            int roomCount = Util.getInt(req, "RoomCount");
            double price = Util.getDouble(req, "Price");
            double area = Util.getDouble(req, "Area");
            int fk_users = userInSession.getId();
            Ad ad = new Ad(id, description, address, floor, floors, roomCount, price, area, fk_users);
            DAO.getDAO().ad.create(ad);
            return null;
        } else
            return null;
    }
}
