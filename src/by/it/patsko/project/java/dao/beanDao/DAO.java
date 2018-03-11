package by.it.patsko.project.java.dao.beanDao;


import by.it.patsko.project.java.dao.ConnectionCreator;

import java.sql.*;

public class DAO {
    private static DAO dao;

    public RoleDAO roleDAO;
    public UserDAO userDAO;
    public ListOfPurchasesDAO listOfPurchasesDAO;
    public BookDAO bookDAO;
    /*public UniversalDAO<ListOfPurchases> listOfPurchasesDAO;
    public UniversalDAO<Book> bookDAO;*/
    public CategoryDAO categoryDAO;
    public CatalogDAO catalogDAO;

    public static DAO getDAO() {
        if (dao == null) {
            dao = new DAO();
            dao.roleDAO = new RoleDAO();
            dao.userDAO = new UserDAO();
            /*beanDao.listOfPurchasesDAO =new UniversalDAO<>(new ListOfPurchases(),"list of purchases");
            beanDao.bookDAO = new UniversalDAO<>(new Book(),"books");*/
            dao.listOfPurchasesDAO =new ListOfPurchasesDAO();
            dao.bookDAO = new BookDAO();
            dao.categoryDAO = new CategoryDAO();
            dao.catalogDAO = new CatalogDAO();
        }
        return dao;
    }

    private static int create(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            int recCount = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            int id=-1;
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()){
                    id= keys.getInt(1);
                    keys.close();
                }
            }
            return id;
        }
    }

    public static int executeUpdate(String sql) throws SQLException {
        if (sql.toUpperCase().trim().startsWith("INSERT "))
            return create(sql);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return statement.executeUpdate(sql);
        }
    }
}
