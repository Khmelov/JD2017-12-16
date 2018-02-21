package by.it.sevashko.jd03_02.beans;

import java.util.Date;
import java.util.Objects;

public class Subscription {

    private int id;
    private int user;
    private int publication;
    private int copies;
    private int period;
    private Date start_subscription;
    private Date end_subscription;
    private float price;

    public Subscription() {
    }

    public Subscription(int id, int user, int publication, int copies, int period, Date start_subscription, Date end_subscription, float price) {
        this.id = id;
        this.user = user;
        this.publication = publication;
        this.copies = copies;
        this.period = period;
        this.start_subscription = start_subscription;
        this.end_subscription = end_subscription;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setStart_subscription(Date start_subscription) {
        this.start_subscription = start_subscription;
    }

    public void setEnd_subscription(Date end_subscription) {
        this.end_subscription = end_subscription;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public int getPublication() {
        return publication;
    }

    public int getCopies() {
        return copies;
    }

    public int getPeriod() {
        return period;
    }

    public Date getStart_subscription() {
        return start_subscription;
    }

    public Date getEnd_subscription() {
        return end_subscription;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id &&
                user == that.user &&
                publication == that.publication &&
                copies == that.copies &&
                period == that.period &&
                Float.compare(that.price, price) == 0 &&
                Objects.equals(start_subscription, that.start_subscription) &&
                Objects.equals(end_subscription, that.end_subscription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, publication, copies, period, start_subscription, end_subscription, price);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", user=" + user +
                ", publication=" + publication +
                ", copies=" + copies +
                ", period=" + period +
                ", start_subscription=" + start_subscription +
                ", end_subscription=" + end_subscription +
                ", price=" + price +
                '}';
    }
}