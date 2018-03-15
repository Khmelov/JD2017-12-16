package by.it.sendetskaya.project.java.DAO;

import by.it.sendetskaya.project.java.DAO.beanDAO.BasketDAO;
import by.it.sendetskaya.project.java.DAO.beanDAO.BuyerDAO;
import by.it.sendetskaya.project.java.DAO.beanDAO.GoodDAO;
import by.it.sendetskaya.project.java.DAO.beanDAO.RoleDAO;

public class DAO {

    private static DAO dao;        //singleton

    public final BuyerDAO buyerDAO;
    public final RoleDAO roleDAO;
    public final GoodDAO goodDAO;
    public final BasketDAO basketDAO;

    public DAO() {
        this.buyerDAO = new BuyerDAO();
        this.roleDAO = new RoleDAO();
        this.goodDAO = new GoodDAO();
        this.basketDAO = new BasketDAO();
    }

    public static DAO getDAO()
    {
        if (dao==null)
        {
            synchronized (DAO.class){
                if(dao==null){
                    dao=new DAO();
                }
            }
        }
        return dao;
    }
}
