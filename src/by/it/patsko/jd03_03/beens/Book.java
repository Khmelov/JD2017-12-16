package by.it.patsko.jd03_03.beens;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private int 	price;
    private int Category_id;

    public Book() {
    }

    public Book(int id, String name, String author, int price, int category_id) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        Category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int category_id) {
        Category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Double.compare(book.price, price) == 0 &&
                Category_id == book.Category_id &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, author, price, Category_id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", Category_id=" + Category_id +
                '}';
    }
}
