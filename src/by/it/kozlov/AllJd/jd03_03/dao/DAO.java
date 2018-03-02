package by.it.kozlov.jd03_03.dao;

import by.it.kozlov.jd03_03.DAOCRUD;
import by.it.kozlov.jd03_03.beans.Car;

public class DAO {
    private static DAO dao;
    public UserDAO user;
    public RoleDAO role;
    public CityDAO city;
    public BrandDAO brand;
    public DAOCRUD car;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.city = new CityDAO();
                    dao.brand = new BrandDAO();
                    dao.car = new DAOCRUD(new Car(),"kozlov","cars");
                }
            }
        }
        return dao;
    }
}