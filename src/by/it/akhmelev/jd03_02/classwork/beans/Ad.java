package by.it.akhmelev.jd03_02.classwork.beans;

import java.io.Serializable;

public class Ad implements Serializable{
    private static final long serialVersionUID = 8535708067584631402L;

    private int id;
    private int roomCount;
    private int flat;
    private int flats;
    private double price;
    private double area;
    private String description;
    private String address;
    private int fk_users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getFlats() {
        return flats;
    }

    public void setFlats(int flats) {
        this.flats = flats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFk_users() {
        return fk_users;
    }

    public void setFk_users(int fk_users) {
        this.fk_users = fk_users;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (id != ad.id) return false;
        if (roomCount != ad.roomCount) return false;
        if (flat != ad.flat) return false;
        if (flats != ad.flats) return false;
        if (Double.compare(ad.price, price) != 0) return false;
        if (Double.compare(ad.area, area) != 0) return false;
        if (fk_users != ad.fk_users) return false;
        if (description != null ? !description.equals(ad.description) : ad.description != null) return false;
        return address != null ? address.equals(ad.address) : ad.address == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + roomCount;
        result = 31 * result + flat;
        result = 31 * result + flats;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + fk_users;
        return result;
    }

    public Ad(int id, int roomCount, int flat, int flats, double price, double area, String description, String address, int fk_users) {
        this.id = id;
        this.roomCount = roomCount;
        this.flat = flat;
        this.flats = flats;
        this.price = price;
        this.area = area;
        this.description = description;
        this.address = address;
        this.fk_users = fk_users;
    }


    public Ad() {
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", roomCount=" + roomCount +
                ", flat=" + flat +
                ", flats=" + flats +
                ", price=" + price +
                ", area=" + area +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", fk_users=" + fk_users +
                "}";
    }
}

