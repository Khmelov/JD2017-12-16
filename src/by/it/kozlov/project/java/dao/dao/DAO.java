package by.it.kozlov.project.java.dao.dao;

public class DAO {
    private static DAO dao;
    public UserDAO user;
    public RoleDAO role;
    public CityDAO city;
    public BrandDAO brand;
    public CarDAO car;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.city = new CityDAO();
                    dao.brand = new BrandDAO();
                    dao.car = new CarDAO();
                }
            }
        }
        return dao;
    }
}