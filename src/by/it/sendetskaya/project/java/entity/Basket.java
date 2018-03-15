package by.it.sendetskaya.project.java.entity;

import java.io.Serializable;
import java.util.Objects;

public class Basket implements Serializable{
    private int id;
    private int quantity;
    private Double sum;
    private int fk_buyers;
    private int fk_goods;

    public Basket() {
    }

    public Basket(int id, int quantity, Double sum, int fk_buyers, int fk_goods) {
        this.id = id;
        this.quantity = quantity;
        this.sum = sum;
        this.fk_buyers = fk_buyers;
        this.fk_goods = fk_goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public int getFk_buyers() {
        return fk_buyers;
    }

    public void setFk_buyers(int fk_buyers) {
        this.fk_buyers = fk_buyers;
    }

    public int getFk_goods() {
        return fk_goods;
    }

    public void setFk_goods(int fk_goods) {
        this.fk_goods = fk_goods;
    }

    @Override
    public String toString() {
        return "Basket {" +
                "id=" + id +
                ", quantity=" + quantity +
                ", sum=" + sum +
                ", fk_buyers=" + fk_buyers +
                ", fk_goods=" + fk_goods +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id &&
                quantity == basket.quantity &&
                fk_buyers == basket.fk_buyers &&
                fk_goods == basket.fk_goods &&
                Objects.equals(sum, basket.sum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, quantity, sum, fk_buyers, fk_goods);
    }
}
