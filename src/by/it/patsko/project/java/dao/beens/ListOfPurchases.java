package by.it.patsko.project.java.dao.beens;

import java.util.Objects;

public class ListOfPurchases {
    private int id;
    private int users_id;
    private int books_id;

    public ListOfPurchases() {
    }

    public ListOfPurchases(int id, int users_id, int books_id) {
        this.id = id;
        this.users_id = users_id;
        this.books_id = books_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int books_id) {
        this.books_id = books_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfPurchases that = (ListOfPurchases) o;
        return id == that.id &&
                users_id == that.users_id &&
                books_id == that.books_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, users_id, books_id);
    }

    @Override
    public String toString() {
        return "ListOfPurchases{" +
                "id=" + id +
                ", users_id=" + users_id +
                ", books_id=" + books_id +
                '}';
    }
}
