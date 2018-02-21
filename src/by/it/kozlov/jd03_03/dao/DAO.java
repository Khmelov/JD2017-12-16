package by.it.kozlov.jd03_03.dao;

public class DAO {
    private static DAO dao;
    public UserDAO user;
    public RoleDAO role;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                }
            }
        }
        return dao;
    }
}