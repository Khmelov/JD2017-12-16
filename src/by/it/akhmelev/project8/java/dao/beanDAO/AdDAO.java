package by.it.akhmelev.project8.java.dao.beanDAO;

import by.it.akhmelev.project8.java.entity.Ad;

public class AdDAO extends UniversalDAO<Ad> {
    public AdDAO(Ad ad, String sqlTableName) {
        super(ad, sqlTableName);
    }
}
