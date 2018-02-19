package by.it.patsko.jd03_02.crud;

import java.util.Objects;

public class ListOfPurchases {
    private int id;
    private int Buyers_id;
    private int Books_id;

    public ListOfPurchases() {
    }

    public ListOfPurchases(int id, int buyers_id, int books_id) {
        this.id = id;
        Buyers_id = buyers_id;
        Books_id = books_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyers_id() {
        return Buyers_id;
    }

    public void setBuyers_id(int buyers_id) {
        Buyers_id = buyers_id;
    }

    public int getBooks_id() {
        return Books_id;
    }

    public void setBooks_id(int books_id) {
        Books_id = books_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfPurchases that = (ListOfPurchases) o;
        return id == that.id &&
                Buyers_id == that.Buyers_id &&
                Books_id == that.Books_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, Buyers_id, Books_id);
    }

    @Override
    public String toString() {
        return "ListOfPurchases{" +
                "id=" + id +
                ", Buyers_id=" + Buyers_id +
                ", Books_id=" + Books_id +
                '}';
    }
}
