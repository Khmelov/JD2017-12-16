package by.it.sevashko.jd03_03;

import by.it.sevashko.jd03_03.dao.PublicationDAO;
import by.it.sevashko.jd03_03.dao.RoleDAO;
import by.it.sevashko.jd03_03.dao.SubscriptionsDAO;
import by.it.sevashko.jd03_03.dao.UserDAO;

public class DAO {

    private static DAO instance;

    final RoleDAO roleDAO;
    final UserDAO userDAO;
    final PublicationDAO publicationDAO;
    final SubscriptionsDAO subscriptionsDAO;

    private DAO(){
        this.roleDAO = new RoleDAO();
        this.userDAO = new UserDAO();
        this.publicationDAO = new PublicationDAO();
        this.subscriptionsDAO = new SubscriptionsDAO();
    }

    public static DAO getDAO(){
        if (instance == null){
            synchronized (DAO.class){
                if (instance == null){
                    instance = new DAO();
                }
            }
        }
        return instance;
    }
}
