package by.it.sevashko.jd03_02.beans;

import java.util.Objects;

public class Publication {

    private int id;
    private String name;
    private int periodicity;
    private int minPeriod;
    private double price;

    public Publication() {
    }

    public Publication(int id, String name, int periodicity, int minPeriod, float price) {
        this.id = id;
        this.name = name;
        this.periodicity = periodicity;
        this.minPeriod = minPeriod;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public void setMinPeriod(int minPeriod) {
        this.minPeriod = minPeriod;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPeriodicity() {
        return periodicity;
    }

    public int getMinPeriod() {
        return minPeriod;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return id == that.id &&
                periodicity == that.periodicity &&
                minPeriod == that.minPeriod &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, periodicity, minPeriod, price);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", periodicity=" + periodicity +
                ", minPeriod=" + minPeriod +
                ", price=" + price +
                '}';
    }
}
