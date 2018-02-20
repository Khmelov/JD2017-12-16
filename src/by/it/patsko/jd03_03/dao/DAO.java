package by.it.patsko.jd03_03.dao;

import by.it.patsko.jd03_03.ConnectionCreator;
import by.it.patsko.jd03_03.beens.*;

import java.sql.*;

public class DAO {
    private static DAO dao;

    public RoleDAO roleDAO;
    public BuyerDAO buyerDAO;
    public ListOfPurchasesDAO listOfPurchasesDAO;
    public BookDAO bookDAO;
    public CategoryDAO categoryDAO;
    public CatalogDAO catalogDAO;


    public static DAO getDAO() {
        if (dao == null) {
            dao = new DAO();
            dao.roleDAO = new RoleDAO();
            dao.buyerDAO = new BuyerDAO();
            dao.listOfPurchasesDAO = new ListOfPurchasesDAO();
            dao.bookDAO = new BookDAO();
            dao.categoryDAO = new CategoryDAO();
            dao.catalogDAO = new CatalogDAO();
        }
        return dao;
    }

    private static int create(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next())
                    return keys.getInt(1);
            }
        }
        return -1;
    }

    public static int executeUpdate(String sql) throws SQLException {
        if (sql.toUpperCase().startsWith("INSERT ")) return create(sql);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        }
    }
}
