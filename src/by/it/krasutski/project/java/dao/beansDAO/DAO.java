package by.it.krasutski.project.java.dao.beansDAO;

public class DAO {

    private static DAO dao;

    public final RoleDAO roleDAO;
    public final UserDAO userDAO;
    public final AdDAO adDAO;
    public final CategoryDAO categoryDAO;


    private DAO() {
        roleDAO = new RoleDAO();
        userDAO = new UserDAO();
        adDAO = new AdDAO();
        categoryDAO = new CategoryDAO();
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
