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
        User userInSession = Util.findInSession(req, "user");
        if (userInSession == null)
            return Actions.LOGIN.command;
        //create or show form
        if (Util.isPost(req)) {
            int id = 0;
            String description = Util.frmString(req, "Description", ".*");
            String address = Util.frmString(req, "Address", ".*");
            int floor = Util.frmInt(req, "Floor");
            int floors = Util.frmInt(req, "Floors");
            int roomCount = Util.frmInt(req, "RoomCount");
            double price = Util.frmDouble(req, "Price");
            double area = Util.frmDouble(req, "Area");
            int fk_users = userInSession.getId();
            Ad ad = new Ad(id, description, address, floor, floors, roomCount, price, area, fk_users);
            DAO.getDAO().ad.create(ad);
            return null;
        } else
            return null;
    }
}
