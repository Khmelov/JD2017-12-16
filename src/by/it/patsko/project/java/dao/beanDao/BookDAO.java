package by.it.patsko.project.java.dao.beanDao;

import by.it.patsko.project.java.dao.ConnectionCreator;
import by.it.patsko.project.java.dao.beens.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DAO implements I_DAO<Book> {

    @Override
    public boolean create(Book book) throws SQLException {
        book.setId(0);
        int id = executeUpdate(String.format("INSERT INTO `books`(`name`, `author`, `price`, `Category_id`) " +
                        "VALUES ('%s','%s','%d','%d')",
                book.getName(), book.getAuthor(), book.getPrice(), book.getCategory_id()));
        if (id > 0) book.setId(id);
        return id > 0;
    }

    @Override
    public Book read(int id) throws SQLException {
        List<Book> bookList = getAll(" where id=" + id);
        return !bookList.isEmpty() ? bookList.get(0) : null;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `books` " +
                                "SET `name`='%s',`author`='%s',`price`='%d',`Category_id`='%d' WHERE id=%d",
                        book.getName(), book.getAuthor(), book.getPrice(), book.getCategory_id(), book.getId()));
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `books` WHERE id=%d", book.getId()));
    }

    @Override
    public List<Book> getAll(String where) throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM `books`" + where + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet books = statement.executeQuery(sql)
        ) {
            while (books.next()) {
                bookList.add(
                        new Book(
                                books.getInt("id"),
                                books.getString("name"),
                                books.getString("author"),
                                books.getInt("price"),
                                books.getInt("Category_id")
                        )
                );
            }
        }
        return bookList;
    }
}
