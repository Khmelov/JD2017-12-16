package by.it.viktorbrui.jd03_03;

import by.it.viktorbrui.jd03_03.bean.Product;
import by.it.viktorbrui.jd03_03.beanDAO.ProductDAO;
import by.it.viktorbrui.jd03_03.beanDAO.RoleDAO;
import by.it.viktorbrui.jd03_03.beanDAO.UniversalDAO;
import by.it.viktorbrui.jd03_03.beanDAO.UserDAO;

public class DAO {

    private static DAO dao = null;

    public final RoleDAO roleDAO;
    public final UserDAO userDAO;
    public final UniversalDAO<Product> prductDAO;


    private DAO() {
        roleDAO = new RoleDAO();
        userDAO = new UserDAO();
        prductDAO = new UniversalDAO<>(new Product(),"Products");
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
