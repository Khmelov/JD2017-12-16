package by.it.akhmelev.jd03_03.classwork;

import by.it.akhmelev.jd03_03.classwork.bean.Ad;
import by.it.akhmelev.jd03_03.classwork.beanDAO.AdDAO;
import by.it.akhmelev.jd03_03.classwork.beanDAO.RoleDAO;
import by.it.akhmelev.jd03_03.classwork.beanDAO.UniversalDAO;
import by.it.akhmelev.jd03_03.classwork.beanDAO.UserDAO;

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
