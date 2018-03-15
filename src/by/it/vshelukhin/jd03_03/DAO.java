package by.it.vshelukhin.jd03_03;

import by.it.vshelukhin.jd03_03.beansDAO.ProductDAO;
import by.it.vshelukhin.jd03_03.beansDAO.RoliesDAO;
import by.it.vshelukhin.jd03_03.beansDAO.StudentDAO;

public class DAO {
    static private DAO dao;
    public StudentDAO studentDAO;
    public ProductDAO productDAO;
    public RoliesDAO roliesDAO;

    private DAO(){
        super();
        studentDAO = new StudentDAO();
        productDAO = new ProductDAO();
        roliesDAO = new RoliesDAO();
    }

    static public DAO getDAO(){
        if (dao == null){
            synchronized (DAO.class){
                if (dao == null){
                    dao = new DAO();
                }
            }
        }
        return dao;
    }
}
