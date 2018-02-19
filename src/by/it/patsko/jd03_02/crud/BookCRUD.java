package by.it.patsko.jd03_02.crud;

import by.it.patsko.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookCRUD implements I_CRUD<Book> {

    @Override
    public boolean create(Book book) throws SQLException {
        book.setId(0);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("INSERT INTO `books`(`name`, `author`, `price`, `Category_id`) " +
                                    "VALUES ('%s','%s','%f','%d')",
                            book.getName(), book.getAuthor(), book.getPrice(), book.getCategory_id()),
                    Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) book.setId(keys.getInt(1));
            }
            return recCount == 1;
        }
    }

    @Override
    public Book read(int id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet books = statement.executeQuery(
                    String.format("SELECT * FROM `books` WHERE id=%d", id));
            if (books.next()) {
                return new Book(
                        books.getInt("id"),
                        books.getString("name"),
                        books.getString("author"),
                        books.getDouble("price"),
                        books.getInt("Category_id")
                );
            }
        }
        return null;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("UPDATE `books` " +
                    "SET `name`='%s',`author`='%s',`price`='%f',`Category_id`='%d' WHERE id=%d",
                            book.getName(),book.getAuthor(),book.getPrice(),book.getCategory_id(), book.getId()));
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("DELETE FROM `books` WHERE id=%d", book.getId()));
            return recCount == 1;
        }
    }
}
