package by.it.akhmelev.project5.java.dao;

import by.it.akhmelev.project5.java.dao.bean.Ad;
import by.it.akhmelev.project5.java.dao.beanDAO.RoleDAO;
import by.it.akhmelev.project5.java.dao.beanDAO.UniversalDAO;
import by.it.akhmelev.project5.java.dao.beanDAO.UserDAO;

public class DAO {

    private static DAO dao = null;

    public final RoleDAO roleDAO;
    public final UserDAO userDAO;
    public final UniversalDAO<Ad> adDAO;


    private DAO() {
        roleDAO = new RoleDAO();
        userDAO = new UserDAO();
        adDAO = new UniversalDAO<>(new Ad(),"ads");
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
