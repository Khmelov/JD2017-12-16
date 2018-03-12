package by.it.vshelukhin.jd03_07.java.dao;


import by.it.vshelukhin.jd03_07.java.dao.beansDAO.RoliesDAO;
import by.it.vshelukhin.jd03_07.java.dao.beansDAO.StudentDAO;
import by.it.vshelukhin.jd03_07.java.dao.beansDAO.WorkDAO;
import by.it.vshelukhin.jd03_07.java.dao.beansDAO.ZakazDAO;

public class DAO {
    static private DAO dao;
    public StudentDAO studentDAO;
    public ZakazDAO zakazDAO;
    public RoliesDAO roliesDAO;
    public WorkDAO workDAO;

    private DAO(){
        super();
        studentDAO = new StudentDAO();
        zakazDAO = new ZakazDAO();
        roliesDAO = new RoliesDAO();
        workDAO = new WorkDAO();
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
