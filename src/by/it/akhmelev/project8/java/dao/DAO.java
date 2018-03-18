package by.it.akhmelev.project8.java.dao;

import by.it.akhmelev.project8.java.dao.beanDAO.AdDAO;
import by.it.akhmelev.project8.java.entity.Ad;
import by.it.akhmelev.project8.java.dao.beanDAO.RoleDAO;
import by.it.akhmelev.project8.java.dao.beanDAO.UserDAO;

public class DAO {

    private static DAO dao = null;

    public final RoleDAO role;
    public final UserDAO user;
    public final AdDAO ad;


    private DAO() {
        role = new RoleDAO();
        user = new UserDAO();
        ad = new AdDAO(Ad.class,"ads");
    }

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                }
            }
        }
        return dao;
    }
}
