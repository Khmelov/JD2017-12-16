package by.it.krasutski.project.java.entity;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable{

    private int ID;
    private String Name;

    public Category(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public Category() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return ID == category.ID &&
                Objects.equals(Name, category.Name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, Name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
