package by.it.akhmelev.project8.java.dao.beanDAO;

import by.it.akhmelev.project8.java.entity.Ad;

public class AdDAO extends UniversalDAO<Ad> {
    public AdDAO(Class<Ad> adClass, String sqlTableName) {
        super(adClass, sqlTableName);
    }
}
