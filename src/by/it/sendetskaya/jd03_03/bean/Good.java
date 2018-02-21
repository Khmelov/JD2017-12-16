package by.it.sendetskaya.jd03_03.bean;

import java.io.Serializable;
import java.util.Objects;

public class Good implements Serializable{
    private int id;
    private String name;
    private Double price;
    private String size;
    private String colour;
    private String structure;
    private String description;

    public Good() {
    }

    public Good(int id, String name, Double price, String size, String colour, String structure, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.colour = colour;
        this.structure = structure;
        this.description = description;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Good {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                ", structure='" + structure + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id &&
                Objects.equals(name, good.name) &&
                Objects.equals(price, good.price) &&
                Objects.equals(size, good.size) &&
                Objects.equals(colour, good.colour) &&
                Objects.equals(structure, good.structure) &&
                Objects.equals(description, good.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, size, colour, structure, description);
    }
}
