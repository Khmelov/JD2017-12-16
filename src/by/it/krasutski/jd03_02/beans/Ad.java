package by.it.krasutski.jd03_02.beans;

import java.io.Serializable;
import java.util.Objects;

public class Ad implements Serializable {

    private int ID;
    private String Title, SmallDesc, Description;
    private int Price;
    private int users_ID, category_ID;

    public Ad(int ID, String title, String smallDesc, String description, int price, int users_ID, int category_ID) {
        this.ID = ID;
        Title = title;
        SmallDesc = smallDesc;
        Description = description;
        Price = price;
        this.users_ID = users_ID;
        this.category_ID = category_ID;
    }

    public Ad() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSmallDesc() {
        return SmallDesc;
    }

    public void setSmallDesc(String smallDesc) {
        SmallDesc = smallDesc;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return ID == ad.ID &&
                Double.compare(ad.Price, Price) == 0 &&
                users_ID == ad.users_ID &&
                category_ID == ad.category_ID &&
                Objects.equals(Title, ad.Title) &&
                Objects.equals(SmallDesc, ad.SmallDesc) &&
                Objects.equals(Description, ad.Description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, Title, SmallDesc, Description, Price, users_ID, category_ID);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", SmallDesc='" + SmallDesc + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", users_ID=" + users_ID +
                ", category_ID=" + category_ID +
                '}';
    }
}
