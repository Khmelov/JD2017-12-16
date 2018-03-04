package by.it.karpeichyk.Project.java.dao.DAO;


public class MyDAO {
    private static MyDAO myDAO = null;


    public MyRoleDAO myRoleDAO;
    public MyUserDAO myUserDAO;
    public MyAdDAO myAdDAO;


    private MyDAO() {
        myRoleDAO = new MyRoleDAO();
        myUserDAO = new MyUserDAO();
        myAdDAO = new MyAdDAO();
    }

    public static MyDAO getMyDAO() {
        if (myDAO == null) {
            synchronized (MyDAO.class) {
                if (myDAO == null) {
                    myDAO = new MyDAO();
                }
            }
        }

        return myDAO;
    }
}
