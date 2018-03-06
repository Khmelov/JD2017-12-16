package by.it.sevashko.project.java.dao;

import by.it.sevashko.project.java.dao.beanDAO.PublicationDAO;
import by.it.sevashko.project.java.dao.beanDAO.RoleDAO;
import by.it.sevashko.project.java.dao.beanDAO.SubscriptionsDAO;
import by.it.sevashko.project.java.dao.beanDAO.UserDAO;

public class DAO {

    private static DAO instance;

    public final RoleDAO roleDAO;
    public final UserDAO userDAO;
    public final PublicationDAO publicationDAO;
    public final SubscriptionsDAO subscriptionsDAO;

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
